package com.example.api_wallet.service;

import com.example.api_wallet.entity.Transaction;
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

    public Flux<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Flux<Transaction> getTransactionsByWalletId(String walletId) {
        return transactionRepository.findByWalletId(walletId);
    }

    public Mono<Transaction> purchase(String walletId, Transaction transaction) {
        return null;
    }

    public Mono<Transaction> sell(String walletId, Transaction transaction) {
       return null;
    }
}
