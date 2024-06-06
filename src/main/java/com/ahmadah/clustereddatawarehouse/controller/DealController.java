package com.ahmadah.clustereddatawarehouse.controller;

import com.ahmadah.clustereddatawarehouse.model.Deal;
import com.ahmadah.clustereddatawarehouse.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DealController {
    private final DealService dealService;

    @GetMapping("/")
    public List<Deal> getAllDeal() {
        return dealService.getAllDeals();
    }
    @PostMapping("/")
    public ResponseEntity<String> addDeal(@RequestBody Deal deal) {
        try {
            var d=dealService.addDeal(deal);
            return ResponseEntity.ok("Deal added successfully :"+d.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
