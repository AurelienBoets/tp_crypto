package com.example.api_wallet.service;

import com.example.api_wallet.entity.Transaction;
import com.example.api_wallet.entity.Wallet;
import com.example.api_wallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Mono<Transaction> saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Flux<Transaction> getTransactionByWallet(Wallet wallet) {
        return transactionRepository.findByWalletId(wallet.getIdWallet());
    }

}
