package com.example.api_market.entity;


import com.example.api_market.repository.MarketRepository;
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
public abstract class Market implements MarketRepository {

    @Id
    private String id;
    private String name;
    private double price;

}
