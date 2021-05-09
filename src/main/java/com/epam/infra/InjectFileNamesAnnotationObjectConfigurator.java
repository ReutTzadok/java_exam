package com.epam.infra;

import com.epam.common.services.PropertiesMapSingleton;
import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InjectFileNamesAnnotationObjectConfigurator implements ObjectConfigurator{

    private PropertiesMapSingleton propertyMap = PropertiesMapSingleton.getInstance();

    @SneakyThrows
    @Override
    public void configure(ApplicationContext context, Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectFileNames annotation = field.getAnnotation(InjectFileNames.class);
            if (annotation != null) {
                String propertyName = annotation.value();
                File[] tmp = new File(propertyMap.getProperty(propertyName)).listFiles();
                List<String> existFiles = tmp == null ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(tmp))
                                .stream()
                                .map(File::getName).
                                collect(Collectors.toList());

                field.setAccessible(true);
                field.set(t, existFiles);
            }
        }
    }
}
