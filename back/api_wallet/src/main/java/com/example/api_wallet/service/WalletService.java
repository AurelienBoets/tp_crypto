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

    public Mono<Wallet> getWalletById(String id) {
        return walletRepository.findById(id);
    }

    public Flux<Wallet> getWalletByUser(String id) {
        return walletRepository.findByUserId(id);
    }


    public Mono<Wallet> purchase(String walletId, Transaction transaction) {
        return walletRepository.findById(walletId).flatMap(walletEdit -> {
            walletEdit.setSold(walletEdit.getSold() + (transaction.getPrice()*transaction.getQuantity()));
            walletEdit.setQuantity(walletEdit.getQuantity() + transaction.getQuantity());
            return walletRepository.save(walletEdit).flatMap(walletAddTransaction -> {
                walletAddTransaction.getTransactions().add(transaction);
                return walletRepository.save(walletAddTransaction);
            });
        });
    }

    public Mono<Wallet> sell(String walletId, Transaction transaction) {
        return walletRepository.findById(walletId).flatMap(walletEdit -> {
            walletEdit.setSold(walletEdit.getSold() - (transaction.getPrice()*transaction.getQuantity()));
            walletEdit.setQuantity(walletEdit.getQuantity() - transaction.getQuantity());
            return walletRepository.save(walletEdit).flatMap(walletAddTransaction -> {
                walletAddTransaction.getTransactions().add(transaction);
                return walletRepository.save(walletAddTransaction);
            });
        });
    }
}
