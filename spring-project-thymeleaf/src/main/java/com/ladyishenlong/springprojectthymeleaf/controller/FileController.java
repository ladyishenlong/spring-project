package com.ladyishenlong.springprojectthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 文件的上传和下载
 * 参考文档：https://www.jianshu.com/p/be1af489551c
 */
@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping("/toFile")
    public String toFile() {
        return "/file";//跳转到该页面
    }

    /**
     * 单个文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/fileUpLoad")
    @ResponseBody //返回对象处理为json
    public String fileUpload(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) return "false";

        String fileName = file.getOriginalFilename();
        long size = file.getSize();
        log.info("文件名：{},文件大小：{}", fileName, size);


        //FileLoad的本地路径，即上传路径
        String path = "/Users/ruanchenhao/WorkSpace/FileLoad";
        File dest = new File(path + "/" + fileName);

        //判断父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);//保存文件
            log.info("{}上传成功", fileName);
            return "true";
        } catch (IOException e) {
            log.error("文件上传异常：{}", e.getMessage());
            e.printStackTrace();
            return "false";
        }
    }


    /**
     * 多个文件的上传
     *
     * @param request
     * @return
     */
    @PostMapping("/multiFileUpLoad")
    @ResponseBody
    public String multiFileUpLoad(HttpServletRequest request) {
        //list的长度固定是页面上的数量，这里是3，所以上传不足3个文件会返回false
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
        log.info("总上传文件数量：{}", files.size());

        if (files.isEmpty()) return "false";
        String path = "/Users/ruanchenhao/WorkSpace/FileLoad";

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            long size = file.getSize();
            log.info("文件名：{},文件大小：{}", fileName, size);

            if (file.isEmpty()) return "false";
            else {
                File dest = new File(path + "/" + fileName);
                //判断父目录是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }

                try {
                    file.transferTo(dest);//保存文件
                    log.info("{}上传成功", fileName);
                } catch (IOException e) {
                    log.error("{}上传异常：{}", fileName, e.getMessage());
                    e.printStackTrace();
                    return "false";
                }
            }
        }
        return "true";
    }


    @GetMapping("/download")
    public String downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename = "冰公主 国王 梦想 鬼刀4k壁纸_彼岸图网.jpg";
        String filePath = "/Users/ruanchenhao/WorkSpace/FileLoad";

        File file = new File(filePath + "/" + filename);
        if (!file.exists()) {
            log.info("{}不存在", filename);
        } else {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" +
                    java.net.URLEncoder.encode(filename, "UTF-8"));

            byte[] buffer = new byte[1024];
            FileInputStream fis = null;//文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null;//输出流

            try {
                os = response.getOutputStream();//获取输出流

                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);

                int i = bis.read(buffer);
                while (-1 != i) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                log.info("文件下载异常：{}", e.getMessage());
                e.printStackTrace();
            }


            try {
                bis.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
