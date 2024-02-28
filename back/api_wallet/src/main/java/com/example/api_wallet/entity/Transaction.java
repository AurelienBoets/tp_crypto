package com.example.api_wallet.entity;

import com.example.api_wallet.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Transaction {
    @Id
    private String idTransaction;
    private TransactionType type;
    private double price;
    private int quantity;
    private String walletId;


}
