package com.example.api_market.controller;

import com.example.api_market.entity.Market;
import com.example.api_market.service.MarketService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/markets")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public Flux<Market> getAll() {
        return marketService.getAllMarkets();
    }

    @GetMapping("/{id}")
    public Mono<Market> getMarketById(@PathVariable String id) {
        return marketService.getMarketById(id);
    }

    @PostMapping
    public Mono<Market> createMarket(@RequestBody Market market) {
        return marketService.createMarket(market);
    }

    @PutMapping("/{id}")
    public Mono<Market> updateMarket(@RequestBody Market market, @PathVariable String id) {
        return marketService.updateMarket(id, market.getPrice());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMarketById(@PathVariable String id) {
        return marketService.deleteMarketById(id);
    }
    @DeleteMapping
    public Mono<Void> deleteAllMarkets() {
        return marketService.deleteAllMarkets();
    }
}
