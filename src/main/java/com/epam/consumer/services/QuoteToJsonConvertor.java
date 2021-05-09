package com.epam.consumer.services;

import com.epam.common.model.Quote;

public interface QuoteToJsonConvertor {
    String convert(Quote quote);
}
