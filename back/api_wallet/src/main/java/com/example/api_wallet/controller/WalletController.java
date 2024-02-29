package com.example.api_wallet.controller;


import com.example.api_wallet.entity.Transaction;
import com.example.api_wallet.entity.Wallet;
import com.example.api_wallet.enums.TransactionType;
import com.example.api_wallet.service.TransactionService;
import com.example.api_wallet.service.WalletService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WalletController {
    private final WalletService walletService;
    private final TransactionService transactionService;

    public WalletController(WalletService walletService, TransactionService transactionService) {
        this.walletService = walletService;
        this.transactionService = transactionService;
    }

    @GetMapping("/wallets/{userId}")
    public Flux<Wallet> getWallets(@PathVariable String userId) {
        return walletService.getWalletByUser(userId);
    }

    @PostMapping("/wallets/wallet/{userId}")
    public Mono<Wallet> createWallet(@PathVariable String userId, @RequestBody Wallet wallet) {
        wallet.setUserId(userId);
        return walletService.saveWallet(wallet);
    }

    @GetMapping("/wallets/wallet/{walletId}")
    public Mono<Wallet> getWallet(@PathVariable String walletId){
        return walletService.getWalletById(walletId);
    }

    @PostMapping("/wallets/wallet/{walletId}/transaction")
    public Mono<Wallet> makeTransaction(@RequestBody Transaction transaction,@PathVariable String walletId){
        transaction.setWalletId(walletId);
        if(transaction.getType()== TransactionType.BUY){
            return transactionService.saveTransaction(transaction).flatMap(t-> walletService.purchase(walletId, t));
        }
        return transactionService.saveTransaction(transaction).flatMap(t->walletService.sell(walletId,t));
    }
}

