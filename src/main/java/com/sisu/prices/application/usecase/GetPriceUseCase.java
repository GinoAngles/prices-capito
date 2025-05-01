package com.sisu.prices.application.usecase;

import com.sisu.prices.domain.model.Price;
import com.sisu.prices.infrastructure.persistence.port.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GetPriceUseCase {

    private final PriceRepository priceRepository;

    public GetPriceUseCase(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getPrice(String productId, int brandId, LocalDateTime dateTime) {
        return priceRepository.findPrice(productId, brandId, dateTime);
    }

}
