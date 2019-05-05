package com.ladyishenlong.springprojectthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件的上传和下载
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


}
