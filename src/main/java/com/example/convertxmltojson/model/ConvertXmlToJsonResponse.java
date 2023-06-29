package com.example.convertxmltojson.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ConvertXmlToJsonResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertXmlToJsonResponse {

    @XmlElement(name = "name", required = true)
    private String json;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
