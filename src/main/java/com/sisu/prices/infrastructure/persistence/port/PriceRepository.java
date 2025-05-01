package com.sisu.prices.infrastructure.persistence.port;

import com.sisu.prices.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findPrice(String productId, Integer brandId, LocalDateTime dateAt);

}
