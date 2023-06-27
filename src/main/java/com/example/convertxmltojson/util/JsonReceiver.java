package com.example.convertxmltojson.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class JsonReceiver {
    public void receiveJson(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        String xml = jsonObject.get("xml").getAsString();

        writeXmlToLog(xml);
    }

    private void writeXmlToLog(String xml) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(xml);
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}