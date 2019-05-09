package com.ladyishenlong.springprojectwebservice.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 接口和实现处都要写明 name 和 targetNamespace
 */
@WebService(name = "DemoWebService",
        targetNamespace = "http://webservice.springprojectwebservice.ladyishenlong.com" // 与接口中的命名空间一致,一般是接口的包名倒
)
public interface DemoWebService {

    @WebMethod
    String Hello(String value);

}
