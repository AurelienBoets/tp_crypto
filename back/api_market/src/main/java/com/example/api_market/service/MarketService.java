package com.example.api_market.service;

import com.example.api_market.entity.Market;

import com.example.api_market.repository.MarketRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MarketService {

    private final MarketRepository marketRepository;


    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;

    }

    public Flux<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    public Mono<Market> getMarketById(String id) {
        return marketRepository.findById(id);
    }

    public Mono<Market> createMarket(Market market) {
        return marketRepository.save(market);
    }

    public Mono<Market> updateMarket(String id, double price) {
        return marketRepository.findById(id)
                .flatMap(existingMarket -> {
                    existingMarket.setPrice(price);
                    return marketRepository.save(existingMarket);
                });
    }

    public Mono<Void> deleteMarketById(String id) {
        return marketRepository.deleteById(id);
    }

    public Mono<Void> deleteAllMarkets() {
        return marketRepository.deleteAll();
    }
}

