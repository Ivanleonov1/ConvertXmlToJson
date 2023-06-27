package com.example.convertxmltojson.controllers;

import com.example.convertxmltojson.services.XmlToJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlToJsonController {
    private final XmlToJsonService xmlToJsonService;

    @Autowired
    public XmlToJsonController(XmlToJsonService xmlToJsonService) {
        this.xmlToJsonService = xmlToJsonService;
    }

    @PostMapping("/xml-to-json")
    public String convertXmlToJson(@RequestBody String xml) {
        return xmlToJsonService.convertXmlToJson(xml);
    }
}
