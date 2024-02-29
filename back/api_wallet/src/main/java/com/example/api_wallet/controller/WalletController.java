package com.example.api_wallet.controller;

import com.example.api_wallet.dto.TransactionDTO;
import com.example.api_wallet.dto.WalletDTO;
import com.example.api_wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @PostMapping
    public Mono<ResponseEntity<WalletDTO>> saveWallet(@RequestBody WalletDTO walletDTO) {
        return walletService.saveWallet(walletDTO.toEntity())
                .map(savedWallet -> ResponseEntity.status(HttpStatus.CREATED).body(WalletDTO.fromEntity(savedWallet)));
    }

    @GetMapping
    public Flux<WalletDTO> getAllWallets() {
        return walletService.getAllWallets().map(WalletDTO::fromEntity);
    }

    @GetMapping("/{id}")
    public Mono<WalletDTO> getWalletById(@PathVariable String id) {
        return walletService.getWalletById(id).map(WalletDTO::fromEntity);
    }

//    @PostMapping("/purchase")
//    public Mono<WalletDTO> purchase(@RequestBody WalletDTO walletDTO, @RequestBody TransactionDTO transactionDTO) {
//        return walletService.purchase(walletDTO, transactionDTO);
//    }

//    @PostMapping("/sell")
//    public Mono<WalletDTO> sell(@RequestBody WalletDTO walletDTO, @RequestBody TransactionDTO transactionDTO) {
//        return walletService.sell(walletDTO, transactionDTO);
//    }




}

