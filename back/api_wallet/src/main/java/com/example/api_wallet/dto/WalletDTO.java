package com.example.api_wallet.dto;

import com.example.api_wallet.entity.Transaction;
import com.example.api_wallet.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {
    private String idWallet;
    private double sold;
    private double quantity;
    private List<TransactionDTO> transactions = new ArrayList<>();

    public static WalletDTO fromEntity(Wallet wallet) {
        List<TransactionDTO> transactionDTOs = wallet.getTransactions().stream()
                .map(TransactionDTO::fromEntity)
                .collect(Collectors.toList());

        return WalletDTO.builder()
                .idWallet(wallet.getIdWallet())
                .sold(wallet.getSold())
                .quantity(wallet.getQuantity())
                .transactions(transactionDTOs)
                .build();
    }

    public Wallet toEntity() {
        List<Transaction> transactions = this.getTransactions().stream()
                .map(TransactionDTO::toEntity)
                .collect(Collectors.toList());

        return Wallet.builder()
                .idWallet(this.getIdWallet())
                .sold(this.getSold())
                .quantity(this.getQuantity())
                .transactions(transactions)
                .build();
    }
}
