package com.example.api_market.entity;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Getter
@Setter
@Document(collection = "crypto")
public class Market {

    @Id
    private String id;
    private String name;
    private double price;

}
