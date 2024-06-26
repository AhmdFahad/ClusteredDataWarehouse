package com.ahmadah.clustereddatawarehouse.controller;

import com.ahmadah.clustereddatawarehouse.model.Deal;
import com.ahmadah.clustereddatawarehouse.service.DealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/deals")
@RequiredArgsConstructor
public class DealController {
    private final DealService dealService;

    @GetMapping("/")
    public List<Deal> getAllDeal() {
        return dealService.getAllDeals();
    }
    @PostMapping("/")
    public ResponseEntity<Deal> saveDeal(@Valid @RequestBody Deal deal) {
            var d=dealService.saveDeal(deal);
            return ResponseEntity.ok(d);
        }

}
