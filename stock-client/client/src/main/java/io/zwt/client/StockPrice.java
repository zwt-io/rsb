package io.zwt.client;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StockPrice {

    private String symbol;
    private Double price;
    private LocalDateTime time;
}
