package com.example.api_wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Wallet {
    @Id
    private String idWallet;
    private double sold;
    private double quantity;
    private List<Transaction> transactions;
}
