package com.epam.consumer.services;

import com.epam.common.services.InjectValueFromProperties;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;

public class JsonSaverImpl implements JsonSaver {
    @InjectValueFromProperties("consumer_output_location")
    private String path;

    @SneakyThrows
    @Override
    public void save(String json, String fileName) {

        String filePath = path + fileName + ".json";

        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
