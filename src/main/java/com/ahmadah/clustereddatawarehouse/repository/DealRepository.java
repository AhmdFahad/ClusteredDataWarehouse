package com.ahmadah.clustereddatawarehouse.repository;

import com.ahmadah.clustereddatawarehouse.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal,String> {
}
