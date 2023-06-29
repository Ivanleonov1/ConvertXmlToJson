package com.example.convertxmltojson.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ConvertXmlToJsonRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertXmlToJsonRequest {

    @XmlElement(name = "name", required = true)
    private String xml;

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
