package io.zwt.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

class WebClientStockClientIntegrationTest {

	private WebClient webClient = WebClient.builder().build();

	@Test
	void shouldWork() {
		String symbol = "Wing";
		WebClientStockClient webClientStockClient = new WebClientStockClient(webClient);
		Flux<StockPrice> prices = webClientStockClient.pricesFor(symbol);

		Assertions.assertEquals(5, prices.take(5).count().block());
	}

}
