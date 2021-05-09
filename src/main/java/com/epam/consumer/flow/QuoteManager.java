package com.epam.consumer.flow;

import com.epam.common.model.Quote;
import com.epam.consumer.services.JsonSaver;
import com.epam.consumer.services.QuoteReader;
import com.epam.consumer.services.QuoteToJsonConvertor;
import com.epam.infra.InjectByType;

import java.io.File;

public class QuoteManager {
    @InjectByType
    private QuoteReader reader;

    @InjectByType
    private QuoteToJsonConvertor convertor;

    @InjectByType
    private JsonSaver saver;



    public void handleQuote(File file) {

        Quote q = reader.read(file);
        String json = convertor.convert(q);
        saver.save(json, file.getName());

    }

}
