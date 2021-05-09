package com.epam.common.services;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

public class PropertiesMapSingleton {
    private static PropertiesMapSingleton propertiesMap;

    private final Map<String,String> propertyMap;

    @SneakyThrows
    private PropertiesMapSingleton() {
        URI uri = ClassLoader.getSystemClassLoader().getResource("application.properties").toURI();

        File file = new File(uri);
        propertyMap = new BufferedReader(new FileReader(file)).lines()
                .map(line -> line.split("="))
                .collect(Collectors.toMap(arr -> arr[0].trim(), arr -> arr[1].trim()));
    }

    //------------------------------------------------------------------------------------------------------

    public static PropertiesMapSingleton getInstance() {
        if (propertiesMap == null) {
            propertiesMap = new PropertiesMapSingleton();
        }

        return propertiesMap;
    }

    //--------------------------------------------------------------------------------------------------------

    public String getProperty(String s) {
        return propertyMap.get(s);
    }
}
