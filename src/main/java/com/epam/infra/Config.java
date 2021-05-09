package com.epam.infra;

public interface Config {
    <T> Class<T> getImplClass(Class<T> type);

    String getPackagesToScan();
}
