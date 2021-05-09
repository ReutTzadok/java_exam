package com.epam.consumer;

import com.epam.consumer.flow.NewQuotesManager;
import com.epam.infra.ApplicationContext;
import com.epam.infra.JavaConfig;


public class MainConsumer {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(JavaConfig.builder().packagesToScan("com.epam").build());

        NewQuotesManager newQuotes = context.getObject(NewQuotesManager.class);

        newQuotes.manageNewQuotes();
    }
}
