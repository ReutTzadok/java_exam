package com.epam.producer.repos;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class QuoterRepoImpl implements QuoterRepo {
    @SneakyThrows
    @Override
    public List<String> getAllQuotes() {
        return new BufferedReader(new FileReader("data/quotes.txt"))
                .lines()
                .collect(Collectors.toList());
    }
}
