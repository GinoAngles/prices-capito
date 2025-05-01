package com.sisu.prices.infrastructure.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GetPriceResponse(
        String productId,
        Integer brandId,
        Integer priceList,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal price
) {
}