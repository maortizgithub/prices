package com.challenge.prices.application.domain.repositories;

import com.challenge.prices.application.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("select p from Price p where p.brandId = ?#{[0]} and p.productId = ?#{[1]} and ?#{[2]} between p.startDate and p.endDate ")
    List<Price> findPrices(int brandId, long productId, Date date);
}
