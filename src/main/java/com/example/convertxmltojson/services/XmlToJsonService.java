package com.example.convertxmltojson.services;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class XmlToJsonService {
    public String convertXmlToJson(String xml) {
        // Формирование JSON из XML
        String json = "{\"xml\": \"" + xml + "\"}";

        sendJson(json);

        return json;
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
