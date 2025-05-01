package com.sisu.prices.infrastructure.persistence.adapter;

import com.sisu.prices.domain.model.Price;
import com.sisu.prices.infrastructure.persistence.h2.adapter.H2PriceRepository;
import com.sisu.prices.infrastructure.persistence.port.PriceRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final H2PriceRepository h2Repository;

    public PriceRepositoryImpl(H2PriceRepository h2Repository) {
        this.h2Repository = h2Repository;
    }

    @Override
    public Optional<Price> findPrice(String productId, Integer brandId, LocalDateTime dateAt) {
        return h2Repository.findByProductBrandIdAtDateWithMaxPriority(productId, brandId, dateAt);
    }
}