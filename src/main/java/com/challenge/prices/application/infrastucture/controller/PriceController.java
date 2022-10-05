package com.challenge.prices.application.infrastucture.controller;

import com.challenge.prices.application.domain.mapper.PriceMapper;
import com.challenge.prices.application.domain.model.Price;
import com.challenge.prices.application.domain.services.PriceService;
import com.challenge.prices.application.exceptions.ApplicationException;
import com.challenge.prices.application.exceptions.ErrorDTO;
import com.challenge.prices.application.infrastucture.dto.PriceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("prices")
public class PriceController {

    private final PriceService priceService;
    private final PriceMapper priceMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PriceDTO>> getPrices() throws ApplicationException {
        try {
            List<Price> list = priceService.findAll();
            return ResponseEntity.ok().body(priceMapper.toDto(list));
        } catch (Exception e) {
            throw new ApplicationException(new ErrorDTO("0001", "Can't get prices"), HttpStatus.FORBIDDEN);
        }
    }
}
