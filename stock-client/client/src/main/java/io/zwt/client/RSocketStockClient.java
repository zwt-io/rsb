package io.zwt.client;

import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;

public class RSocketStockClient implements StockClient {

    private RSocketRequester rSocketRequester;

    RSocketStockClient(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @Override
    public Flux<StockPrice> pricesFor(String symbol) {
        return rSocketRequester.route("stockPrices")
                .data(symbol)
                .retrieveFlux(StockPrice.class)
                .log("rsocket");
    }
}
