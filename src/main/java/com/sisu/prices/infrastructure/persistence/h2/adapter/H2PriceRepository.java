package com.sisu.prices.infrastructure.persistence.h2.adapter;

import com.sisu.prices.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface H2PriceRepository extends JpaRepository<Price, Integer> {

    @Query(value = """
            SELECT * FROM price p
            WHERE p.product_id = :productId
            AND p.brand_id = :brandId
            AND :dateAt BETWEEN p.start_date AND p.end_date
            ORDER BY p.priority DESC
            LIMIT 1
            """, nativeQuery = true)
    Optional<Price> findByProductBrandIdAtDateWithMaxPriority(@Param("productId") String productId,
                                                              @Param("brandId") int brandId,
                                                              @Param("dateAt") LocalDateTime dateAt);

}
