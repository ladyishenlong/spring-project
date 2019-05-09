package com.ladyishenlong.springprojectwebservice.config;

import com.ladyishenlong.springprojectwebservice.webservice.DemoWebService;
import com.ladyishenlong.springprojectwebservice.webserviceImpl.DemoWebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 *参考  https://blog.csdn.net/wsgsm/article/details/83409964
 *注册webservice
 */
@Configuration
public class WebServiceConfig {


    /**
     * 注入servlet  bean name不能dispatcherServlet 否则会覆盖dispatcherServlet
     * 此方法作用是改变项目中服务名的前缀名
     * @return
     */
    @Bean(name = "cxfServlet")
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    @Bean
    public DemoWebService demoWebService() {
        return new DemoWebServiceImpl();
    }


    /**
     * 注册DemoWebServiceEndpoint接口到webservice服务
     *
     * @return
     */
    @Bean(name = "DemoWebServiceEndpoint")
    public Endpoint sweptPayEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoWebService());
        endpoint.publish("/demoWebService");
        return endpoint;
    }


}
