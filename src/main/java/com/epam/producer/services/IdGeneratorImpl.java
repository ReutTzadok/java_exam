package com.epam.producer.services;


public class IdGeneratorImpl implements IdGenerator {
    @Override
    public long getNewId() {
        return System.nanoTime();
    }
}
