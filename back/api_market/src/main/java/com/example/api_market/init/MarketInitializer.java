package com.example.api_market.init;

import com.example.api_market.entity.Market;
import com.example.api_market.repository.MarketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MarketInitializer implements CommandLineRunner {

    private final MarketRepository marketRepository;

    public MarketInitializer(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public void run(String... args) {
        initializeMarkets();
    }

    private void initializeMarkets() {
        // Générer des valeurs aléatoires pour les cryptomonnaies
        Random random = new Random();
        double bitcoinPrice = 10000 + random.nextDouble() * 20000; // Valeur entre 10000 et 30000
        double ethereumPrice = 500 + random.nextDouble() * 1000; // Valeur entre 500 et 1500
        double ripplePrice = 0.1 + random.nextDouble() * 0.9; // Valeur entre 0.1 et 1

        // Initialiser les cryptomonnaies dans la base de données
        marketRepository.save(Market.builder().name("Bitcoin").price(bitcoinPrice).build());
        marketRepository.save(Market.builder().name("Ethereum").price(ethereumPrice).build());
        marketRepository.save(Market.builder().name("Ripple").price(ripplePrice).build());
    }
}
