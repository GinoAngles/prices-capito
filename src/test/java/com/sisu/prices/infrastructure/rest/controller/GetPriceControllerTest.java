
package com.sisu.prices.infrastructure.rest.controller;

import com.sisu.prices.infrastructure.rest.dto.GetPriceRequest;
import com.sisu.prices.infrastructure.rest.dto.GetPriceResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetPriceControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @ParameterizedTest
    @CsvSource({
            "35455, 1, 2020-06-14T10:00:00, 35.50",
            "35455, 1, 2020-06-14T16:00:00, 25.45",
            "35455, 1, 2020-06-14T21:00:00, 35.50",
            "35455, 1, 2020-06-15T10:00:00, 30.50",
            "35455, 1, 2020-06-16T21:00:00, 38.95"})
    void shouldReturnPriceForValidRequest(String productId, int brandId, LocalDateTime dateTime, BigDecimal expectedPrice) {
        GetPriceRequest request = new GetPriceRequest(dateTime, productId, brandId);
        HttpEntity<GetPriceRequest> entity = new HttpEntity<>(request, null);

        ResponseEntity<GetPriceResponse> response = restTemplate.exchange(
                "/api/price", HttpMethod.GET, entity, GetPriceResponse.class
        );

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().price()).isEqualTo(expectedPrice);
    }

}