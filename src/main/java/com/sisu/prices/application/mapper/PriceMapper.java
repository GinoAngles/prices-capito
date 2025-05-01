package com.sisu.prices.application.mapper;

import com.sisu.prices.domain.model.Price;
import com.sisu.prices.infrastructure.rest.dto.GetPriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public GetPriceResponse map(Price price) {
        return new GetPriceResponse(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }

}
