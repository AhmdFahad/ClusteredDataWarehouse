package com.ahmadah.clustereddatawarehouse.service;

import com.ahmadah.clustereddatawarehouse.exception.DealAlreadyExistsException;
import com.ahmadah.clustereddatawarehouse.model.Deal;
import com.ahmadah.clustereddatawarehouse.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DealService {
    private final DealRepository dealRepository;

    public List<Deal> getAllDeals(){
        log.info("get ALL deals");
        return dealRepository.findAll();
    }

    public Deal saveDeal(Deal deal) {
        if(dealRepository.existsByDealId(deal.getDealId()))
            throw new DealAlreadyExistsException("Deal with ID " + deal.getDealId() + " already exists.");

        var savedDeal=dealRepository.save(deal);
        log.info("Deal with ID {} added successfully", savedDeal.getDealId());
        return savedDeal;


    }
}
