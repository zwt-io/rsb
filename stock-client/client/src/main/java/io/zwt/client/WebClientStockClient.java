package io.zwt.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class WebClientStockClient implements StockClient {

private WebClient webClient;

	WebClientStockClient(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public Flux<StockPrice> pricesFor(String symbol) {
		return webClient.get()
				.uri("localhost:8080/stocks/{symbol}", symbol)
				.retrieve()
				.bodyToFlux(StockPrice.class);
	}
}
