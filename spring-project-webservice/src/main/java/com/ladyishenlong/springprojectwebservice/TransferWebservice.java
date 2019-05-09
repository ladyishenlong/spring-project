package com.ladyishenlong.springprojectwebservice;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 调用webservice
 */
@Slf4j
public class TransferWebservice {


    public static void main(String[] args) throws Exception{

        //动态连接到webservice
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.
                createClient("http://localhost:10012/webservice/demoWebService?wsdl");

        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));

        Object[] objects = new Object[0];

        // invoke("方法名",参数1,参数2,参数3....);
        objects = client.invoke("Hello", "hello webservice");
        log.info("返回的数据："+objects[0]);


    }
}
