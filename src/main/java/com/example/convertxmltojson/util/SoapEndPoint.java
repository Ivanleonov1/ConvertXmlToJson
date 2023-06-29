package com.example.convertxmltojson.util;

import com.example.convertxmltojson.model.ConvertXmlToJsonRequest;
import com.example.convertxmltojson.model.ConvertXmlToJsonResponse;
import com.example.convertxmltojson.services.XmlToJsonService;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
public class SoapEndPoint {

    private static final String NAMESPACE_URI = "https://example.com/convertxmltojson";


    private final XmlToJsonService xmlToJsonService;

    public SoapEndPoint(XmlToJsonService xmlToJsonService) {
        this.xmlToJsonService = xmlToJsonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ConvertXmlToJsonRequest")
    @ResponsePayload
    public ConvertXmlToJsonResponse convertXmlToJson(@RequestPayload ConvertXmlToJsonRequest request) {
        String xml = request.getXml();
        String json = xmlToJsonService.convertXmlToJson(xml);
        ConvertXmlToJsonResponse response = new ConvertXmlToJsonResponse();
        response.setJson(json);

        return response;
    }
}
