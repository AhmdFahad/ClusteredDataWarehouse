package com.ahmadah.clustereddatawarehouse.service;

import com.ahmadah.clustereddatawarehouse.exception.DealAlreadyExistsException;
import com.ahmadah.clustereddatawarehouse.model.Deal;
import com.ahmadah.clustereddatawarehouse.repository.DealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DealServiceTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private DealService dealService;

    @Test
    void getAllDeals_ShouldReturnAllDeals() {
        var mockdeal = Deal.builder()
                .dealId("123")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDateTime.now())
                .dealAmount(1000L)
                .build();
        List<Deal> deals = Arrays.asList(mockdeal);
        when(dealRepository.findAll()).thenReturn(deals);

        List<Deal> result = dealService.getAllDeals();

        assertEquals(1, result.size());
        assertEquals(mockdeal.getDealId(), result.get(0).getDealId());
        verify(dealRepository, times(1)).findAll();
    }

    @Test
    void addDeal_ShouldSaveNewDeal() {
        var mockdeal = Deal.builder()
                .dealId("123")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDateTime.now())
                .dealAmount(1000L)
                .build();
        when(dealRepository.existsByDealId(mockdeal.getDealId())).thenReturn(false);
        when(dealRepository.save(any(Deal.class))).thenReturn(mockdeal);

        Deal result = dealService.addDeal(mockdeal);

        assertNotNull(result);
        assertEquals(mockdeal.getDealId(), result.getDealId());
        verify(dealRepository, times(1)).existsByDealId(mockdeal.getDealId());
        verify(dealRepository, times(1)).save(mockdeal);
    }

    @Test
    void addDeal_ShouldThrowExceptionWhenDealExists() {
        var deal = Deal.builder()
                .dealId("123")
                .fromCurrencyIsoCode("USD")
                .toCurrencyIsoCode("EUR")
                .dealTimestamp(LocalDateTime.now())
                .dealAmount(1000L)
                .build();
        when(dealRepository.existsByDealId(deal.getDealId())).thenReturn(true);

        assertThrows(DealAlreadyExistsException.class, () -> dealService.addDeal(deal));

        verify(dealRepository, times(1)).existsByDealId(deal.getDealId());
        verify(dealRepository, never()).save(any(Deal.class));
    }

}