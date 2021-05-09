package com.epam.producer.services;

import com.epam.common.model.Quote;
import com.epam.common.services.InjectValueFromProperties;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuoterSaverImpl implements QuoterSaver {

    @InjectValueFromProperties("producer_output_location")
    private String locationDir;

    @SneakyThrows
    @Override
    public void save(Quote quote) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        File file = new File(locationDir + "quote_" + timeStamp);
        file.createNewFile();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(quote);
    }
}
