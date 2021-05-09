package com.epam.consumer.services;

import com.epam.common.services.InjectValueFromProperties;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class JsonSaverImpl implements JsonSaver{
    @InjectValueFromProperties("consumer_output_location")
    private String path;

    @SneakyThrows
    @Override
    public void save(String json, String fileName) {

        String filePath = path + fileName;

        File file = new File(filePath);
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(json);
        oos.close();
    }
}
