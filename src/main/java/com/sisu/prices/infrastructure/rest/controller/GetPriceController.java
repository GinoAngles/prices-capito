package com.sisu.prices.infrastructure.rest.controller;

import com.sisu.prices.application.mapper.PriceMapper;
import com.sisu.prices.application.usecase.GetPriceUseCase;
import com.sisu.prices.infrastructure.rest.dto.GetPriceRequest;
import com.sisu.prices.infrastructure.rest.dto.GetPriceResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class GetPriceController {

    private final GetPriceUseCase getPriceUseCase;
    private final PriceMapper priceMapper;

    public GetPriceController(GetPriceUseCase getPriceUseCase,
                              PriceMapper priceMapper) {
        this.getPriceUseCase = getPriceUseCase;
        this.priceMapper = priceMapper;
    }

    @GetMapping("/api/price")
    public ResponseEntity<GetPriceResponse> getPrice(@RequestBody @Valid GetPriceRequest priceRequest) {
        return getPriceUseCase.getPrice(priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getDateAt())
                .map(priceMapper::map)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

}