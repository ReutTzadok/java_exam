package com.epam.consumer.flow;

import com.epam.common.services.InjectValueFromProperties;
import com.epam.infra.InjectFileNames;
import com.epam.infra.InjectByType;
import com.epam.infra.Singleton;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
@Data
@NoArgsConstructor
public class NewQuotesManager {
    @InjectValueFromProperties("producer_output_location")
    private String sourceDirectory;

    @InjectFileNames("consumer_output_location")
    private List<String> existingFileNames;

    @InjectByType
    QuoteManager quoteManager;



    @SneakyThrows
    public void manageNewQuotes() {
        File allFiles = new File(sourceDirectory);


        while (true) {
            List<File> newFiles = Arrays.asList(Objects.requireNonNull(allFiles.listFiles())).stream()
                    .filter(file -> !existingFileNames.contains(file.getName())).collect(Collectors.toList());

            for (File file : newFiles) {
                quoteManager.handleQuote(file);
                existingFileNames.add(file.getName());
            }

            Thread.sleep(10000);
        }


    }
}
