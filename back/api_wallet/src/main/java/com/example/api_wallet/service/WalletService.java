package com.example.api_wallet.service;

import com.example.api_wallet.entity.Transaction;
import com.example.api_wallet.entity.Wallet;
import com.example.api_wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Mono<Wallet> saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Flux<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Mono<Wallet> getWalletById(String id) {
        return walletRepository.findById(id);
    }

    public Mono<Wallet> purchase(Wallet wallet, Transaction transaction) {
        return  null;
    }

    public Mono<Wallet> sell(Wallet wallet, Transaction transaction) {
       return null;
    }
}
