package com.example.convertxmltojson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.SoapMessageFactory;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.transport.http.WsdlDefinitionHandlerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration
@EnableWs
public class SoapConfig extends WsConfigurerAdapter {

    private static final String WS_NAMESPACE = "https://example.com/convertxmltojson";

    @Bean
    public SoapMessageFactory messageFactory() {
        return new SaajSoapMessageFactory();
    }

    @Bean
    public MessageDispatcherServlet messageDispatcherServlet() {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setMessageFactoryBeanName(messageFactory().toString());
        return servlet;
    }

    @Bean
    public WsdlDefinitionHandlerAdapter wsdlDefinitionHandlerAdapter() {
        WsdlDefinitionHandlerAdapter adapter = new WsdlDefinitionHandlerAdapter();
        adapter.setTransformLocations(true);
        return adapter;
    }

    @Bean(name = "convertxmltojson")
    public DefaultWsdl11Definition defaultWsdl11Definition() {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("8080");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace(WS_NAMESPACE);
        defaultWsdl11Definition.setSchema(schema());
       // defaultWsdl11Definition.setWsdl(wsdl());
        return defaultWsdl11Definition;
    }

    @Bean
    public SimpleXsdSchema schema() {
        return new SimpleXsdSchema();
    }

    @Bean
    public SimpleWsdl11Definition wsdl() {
        return new SimpleWsdl11Definition();

    }
}
