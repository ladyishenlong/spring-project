package com.ladyishenlong.springprojectwebservice.webserviceImpl;

import com.ladyishenlong.springprojectwebservice.webservice.DemoWebService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(serviceName = "DemoWebService",// 与接口中指定的name一致
        targetNamespace = "http://webservice.springprojectwebservice.ladyishenlong.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.ladyishenlong.springprojectwebservice.webservice.DemoWebService" // 接口地址
)
public class DemoWebServiceImpl implements DemoWebService {

    @Override
    public String Hello(String value) {
        return "web service return: "+value;
    }
}

