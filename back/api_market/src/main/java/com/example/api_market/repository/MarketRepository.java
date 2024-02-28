package com.example.api_market.repository;

import com.example.api_market.entity.Market;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
public interface MarketRepository extends ReactiveMongoRepository<Market, String> {

}
