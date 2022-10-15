package com.challenge.prices.application.infrastucture.controller;

import com.challenge.prices.application.domain.mapper.PriceMapper;
import com.challenge.prices.application.domain.model.Price;
import com.challenge.prices.application.domain.services.PriceService;
import com.challenge.prices.application.exceptions.ApplicationException;
import com.challenge.prices.application.exceptions.ErrorDTO;
import com.challenge.prices.application.infrastucture.dto.PriceDTO;
import com.challenge.prices.application.infrastucture.dto.PriceSearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Tag(name = "Prices", description = "Prices controller")
@RequestMapping("prices")
public class PriceController {

    private final PriceService priceService;
    private final PriceMapper priceMapper;

    @Operation(summary = "Find all prices", description = "All prices", tags = { "prices" })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PriceDTO>> getPrices() throws ApplicationException {
        try {
            List<Price> list = priceService.findAll();
            return ResponseEntity.ok().body(priceMapper.toDto(list));
        } catch (Exception e) {
            throw new ApplicationException(new ErrorDTO("0001", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Find prices by filter", description = "Get prices", tags = { "prices" })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDTO> getPricesByQuery(@RequestBody PriceSearchDTO priceSearchDTO) throws ApplicationException {
        try {
            List<Price> list = priceService.findPrices(priceSearchDTO.getBrandId(), priceSearchDTO.getProductId(), priceSearchDTO.getDate());
            Optional<Price> priorityPrice = list.stream().max(Comparator.comparing(Price::getPriority));
            return (!priorityPrice.isPresent())? ResponseEntity.notFound().build() : ResponseEntity.ok().body(priceMapper.toDto(priorityPrice.get()));
        } catch (Exception e) {
            throw new ApplicationException(new ErrorDTO("0001", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
