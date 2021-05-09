package com.epam.producer.services;

import com.epam.common.model.Quote;

public interface QuoteProducer {
    Quote generate();
}
