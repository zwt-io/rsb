package io.zwt.client;

import reactor.core.publisher.Flux;

public interface StockClient {
    Flux<StockPrice> pricesFor(String symbol);
}
