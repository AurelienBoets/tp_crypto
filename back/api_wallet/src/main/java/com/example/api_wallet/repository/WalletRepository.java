package com.example.api_wallet.repository;

import com.example.api_wallet.entity.Wallet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface WalletRepository extends ReactiveMongoRepository<Wallet, String> {
    Flux<Wallet> findByUserId(String userId);
}
