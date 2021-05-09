package com.epam.infra;

import com.epam.common.services.InjectValueFromProperties;
import com.epam.common.services.PropertiesMapSingleton;
import lombok.SneakyThrows;

import java.lang.reflect.Field;


public class InjectValueFromPropertiesAnnotationObjectConfigurator implements ObjectConfigurator {

    private PropertiesMapSingleton propertyMap = PropertiesMapSingleton.getInstance();

    @Override
    @SneakyThrows
    public void configure(ApplicationContext context, Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectValueFromProperties annotation = field.getAnnotation(InjectValueFromProperties.class);
            if (annotation != null) {
                String propertyName = annotation.value();
                field.setAccessible(true);
                field.set(t,propertyMap.getProperty(propertyName));
            }
        }
    }
}
