package com.sisu.prices.application.usecase;

import com.sisu.prices.domain.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GetPriceUseCase {

    public Optional<Price> getPrice(String productId, int brandId, LocalDateTime dateTime) {
        return Optional.empty();
    }

}
