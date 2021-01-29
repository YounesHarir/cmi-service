package com.app.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/soapWS/*");
    }


    @Bean("operation")
    public XsdSchema operationSchema() {
        return new SimpleXsdSchema(new ClassPathResource("operations.xsd"));
    }

    @Bean(name="operationGen")
    public DefaultWsdl11Definition defaultWsdl11Definition(@Qualifier("operation") XsdSchema operationSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(operationSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("OperationServicePort");
        definition.setTargetNamespace("http://app.com/cmi-service");
        return definition;
    }


    @Bean("creancier")
    public XsdSchema creancierSchema() {
        return new SimpleXsdSchema(new ClassPathResource("creanciers.xsd"));
    }

    @Bean(name="creancierGen")
    public DefaultWsdl11Definition creancierWsdl11Definition(@Qualifier("creancier") XsdSchema creancierSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(creancierSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("CreanciersServicePort");
        definition.setTargetNamespace("http://app.com/creanciers-service");
        return definition;
    }

    @Bean("payment")
    public XsdSchema paymentSchema() {
        return new SimpleXsdSchema(new ClassPathResource("payments.xsd"));
    }

    @Bean(name="paymentGen")
    public DefaultWsdl11Definition paymentWsdl11Definition(@Qualifier("payment") XsdSchema paymentSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(paymentSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("PaymentsServicePort");
        definition.setTargetNamespace("http://app.com/payments-service");
        return definition;
    }


}
