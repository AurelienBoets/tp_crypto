package com.example.api_market.service;

import com.example.api_market.entity.Market;
import com.example.api_market.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public Mono<Market> updateMarket(String id, double price) {
        return marketRepository.findById(id).flatMap(market -> {
            market.setPrice(price);
            return marketRepository.save(market);
        });
    }

}
