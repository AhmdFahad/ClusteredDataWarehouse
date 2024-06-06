package com.ahmadah.clustereddatawarehouse.service;

import com.ahmadah.clustereddatawarehouse.model.Deal;
import com.ahmadah.clustereddatawarehouse.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DealService {
    private final DealRepository dealRepository;
    public Deal addDeal(Deal deal) {
       return dealRepository.save(deal);
    }
}
