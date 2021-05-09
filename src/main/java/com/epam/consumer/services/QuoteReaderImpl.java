package com.epam.consumer.services;

import com.epam.common.model.Quote;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class QuoteReaderImpl implements QuoteReader{
    @SneakyThrows
    @Override
    public Quote read(File file) {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (Quote) ois.readObject();
    }
}
