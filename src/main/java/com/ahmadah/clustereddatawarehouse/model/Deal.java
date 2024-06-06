package com.ahmadah.clustereddatawarehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Builder@Setter@Getter@ToString
public class Deal {
    @Id
    private String dealUniqueId;
    private String fromCurrencyIsoCode;
    private String toCurrencyIsoCode;
    private LocalDateTime dealTimestamp;
    private Long dealAmount;

}
