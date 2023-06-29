package com.example.convertxmltojson.services;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.FileWriter;
import java.io.IOException;

@WebService
public interface XmlToJsonService {
    @WebMethod
    public String convertXmlToJson(String xml);

}
