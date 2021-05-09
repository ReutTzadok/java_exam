package com.epam.consumer.services;

import com.epam.common.model.Quote;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class QuoteToJsonConvertorImpl implements QuoteToJsonConvertor{
    @Override
    public String convert(Quote quote) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = quote.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            json.append(fieldToString(field, quote)).append(", ");
        }

        json.delete(json.length() - 2, json.length());
        json.append("}");

        return String.valueOf(json);
    }

    //----------------------------------------------------------------------------------------------

    @SneakyThrows
    private static String fieldToString(Field f, Object o) {
        String s = "\"" + f.getName() + "\": ";

        s += f.getType().equals(String.class) ? "\"" + f.get(o) + "\"" : f.get(o);

        return s;
    }
}
