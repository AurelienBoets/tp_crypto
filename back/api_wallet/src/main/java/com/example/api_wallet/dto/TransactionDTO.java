package com.example.api_wallet.dto;

import com.example.api_wallet.entity.Transaction;
import com.example.api_wallet.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private String idTransaction;
    private TransactionType type;
    private double price;
    private int quantity;
    private String walletId;

    public static TransactionDTO fromEntity(Transaction transaction) {
        return TransactionDTO.builder()
                .idTransaction(transaction.getIdTransaction())
                .type(transaction.getType())
                .price(transaction.getPrice())
                .quantity(transaction.getQuantity())
                .walletId(transaction.getWalletId())
                .build();
    }

    public Transaction toEntity() {
        return Transaction.builder()
                .idTransaction(this.getIdTransaction())
                .type(this.getType())
                .price(this.getPrice())
                .quantity(this.getQuantity())
                .walletId(this.getWalletId())
                .build();
    }
}
