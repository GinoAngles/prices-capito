package com.sisu.prices.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class GetPriceRequest {

    @NotNull(message = "The dateAt can not be null")
    private LocalDateTime dateAt;

    @NotBlank(message = "The productId can not be blank")
    private String productId;

    @NotNull(message = "The brandId can not be null")
    @Positive(message = "The brandId must be positive")
    private Integer brandId;

    public GetPriceRequest(LocalDateTime dateAt, String productId, Integer brandId) {
        this.dateAt = dateAt;
        this.productId = productId;
        this.brandId = brandId;
    }

    public LocalDateTime getDateAt() {
        return dateAt;
    }

    public void setDateAt(LocalDateTime dateAt) {
        this.dateAt = dateAt;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getBrandId() {
        return brandId;
    }

}