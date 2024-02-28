package com.example.api_wallet.controller;

import com.example.api_wallet.dto.TransactionDTO;
import com.example.api_wallet.dto.WalletDTO;
import com.example.api_wallet.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Mono<TransactionDTO> saveTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.saveTransaction(transactionDTO.toEntity())
                .mapNotNull(saveTransaction -> ResponseEntity.status(HttpStatus.CREATED).body(TransactionDTO.fromEntity(saveTransaction)).getBody());
    }


    @GetMapping
    public Flux<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions().map(TransactionDTO::fromEntity);
    }

    @GetMapping("/wallet/{walletId}")
    public Flux<TransactionDTO> getTransactionsByWalletId(@PathVariable String walletId) {
        return transactionService.getTransactionsByWalletId(walletId).map(TransactionDTO::fromEntity);
    }

//    @PostMapping("/purchase/{walletId}")
//    public Mono<TransactionDTO> purchase(@PathVariable String walletId, @RequestBody TransactionDTO transactionDTO) {
//        return transactionService.purchase(walletId, transactionDTO);
//    }
//
//    @PostMapping("/sell/{walletId}")
//    public Mono<TransactionDTO> sell(@PathVariable String walletId, @RequestBody TransactionDTO transactionDTO) {
//        return transactionService.sell(walletId, transactionDTO);
//    }
}
