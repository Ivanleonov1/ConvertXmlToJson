package com.example.convertxmltojson.services.impl;

import com.example.convertxmltojson.services.XmlToJsonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class XmlToJsonServiceImpl implements XmlToJsonService {
    @Override
    public String convertXmlToJson(String xml) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            Object json = objectMapper.readValue(xml, Object.class);
            String jsonString = objectMapper.writeValueAsString(json);

            sendJson(jsonString);

            return jsonString;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

    private void sendJson(String json) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(("Received JSON: " + json));
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Received JSON: " + json);
    }
}
