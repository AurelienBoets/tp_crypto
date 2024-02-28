package com.example.api_market.controller;


import com.example.api_market.entity.Market;
import com.example.api_market.repository.MarketRepository;
import com.example.api_market.service.MarketService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class MarketController {

    private final MarketRepository marketRepository;
    private final MarketService marketService;


    public MarketController(MarketRepository marketRepository, MarketService marketService) {
        this.marketRepository = marketRepository;
        this.marketService = marketService;
    }

    @GetMapping
    public Flux<Market> getAll() {
        return marketRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Market> getMarketById(@PathVariable String id) {
        return marketRepository.findById(id);
    }


    @PostMapping
    public Mono<Market> createMarket(@RequestBody Market market) {
        return marketRepository.save(market);
    }

     @PutMapping("/{id}")
        public Mono<Market> updateMarket(@RequestBody Market market, @PathVariable String id) {
        return marketService.updateMarket(id, market.getPrice());
     }

}
