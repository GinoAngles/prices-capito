package com.sisu.prices.application.usecase;

import com.sisu.prices.domain.model.Price;
import com.sisu.prices.infrastructure.persistence.port.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPriceUseCaseTest {

    @InjectMocks
    GetPriceUseCase service;

    @Mock
    PriceRepository priceRepository;

    @Test
    void whenGettingPrice_thenPriceIsSearched() {
        service.getPrice("35455", 1, LocalDateTime.of(2020, 8, 16, 18, 16, 1));
        verify(priceRepository).findPrice("35455", 1, LocalDateTime.of(2020, 8, 16, 18, 16, 1));
    }

    @Test
    void givenResult_whenGettingPrice_thenItIsReturned() {
        when(priceRepository.findPrice(anyString(), anyInt(), any())).thenReturn(Optional.of(new Price(1, LocalDateTime.now(), LocalDateTime.now(), 1, "35455", 1, new BigDecimal("10.10"), "EUR")));
        Optional<Price> price = service.getPrice("35455", 1, LocalDateTime.of(2020, 8, 16, 18, 16, 1));
        assertEquals(Optional.of(new Price(1, LocalDateTime.now(), LocalDateTime.now(), 1, "35455", 1, new BigDecimal("10.10"), "EUR")), price);
    }

    @Test
    void givenNoResults_whenGettingPrice_thenEmptyIsReturned() {
        when(priceRepository.findPrice(anyString(), anyInt(), any())).thenReturn(Optional.empty());
        Optional<Price> price = service.getPrice("35455", 1, LocalDateTime.of(2020, 8, 16, 18, 16, 1));
        assertEquals(Optional.empty(), price);
    }

}