package com.ahmadah.clustereddatawarehouse.service;

import com.ahmadah.clustereddatawarehouse.model.Deal;
import com.ahmadah.clustereddatawarehouse.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealService {
    private final DealRepository dealRepository;

    public List<Deal> getAllDeals(){
        return dealRepository.findAll();
    }

    public Deal addDeal(Deal deal) {

       return dealRepository.save(deal);
    }
}
