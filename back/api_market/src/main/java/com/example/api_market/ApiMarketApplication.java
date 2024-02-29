package com.example.api_market;

import com.example.api_market.entity.Market;
import com.example.api_market.repository.MarketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class ApiMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMarketApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataInitializer(MarketRepository marketRepository) {
        return args -> {
            deleteAllMarkets(marketRepository);
            initializeMarkets(marketRepository);
        };
    }


    private void deleteAllMarkets(MarketRepository marketRepository) {
        marketRepository.findByName("Bitcoin").flatMap(marketRepository::delete).subscribe();
        marketRepository.findByName("Ethereum").flatMap(marketRepository::delete).subscribe();
        marketRepository.findByName("Ripple").flatMap(marketRepository::delete).subscribe();
    }

    private void initializeMarkets(MarketRepository marketRepository) {

        Random random = new Random();
        double bitcoinPrice = 10000 + random.nextDouble() * 20000;
        double ethereumPrice = 500 + random.nextDouble() * 1000;
        double ripplePrice = 0.1 + random.nextDouble() * 0.9;

        marketRepository.save(Market.builder().name("Bitcoin").price(bitcoinPrice).build()).subscribe();
        marketRepository.save(Market.builder().name("Ethereum").price(ethereumPrice).build()).subscribe();
        marketRepository.save(Market.builder().name("Ripple").price(ripplePrice).build()).subscribe();
    }
}
