package com.ahmadah.clustereddatawarehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Builder@Setter@Getter@ToString
public class Deal {
    @Id
    @NotNull
    private String dealId;
    @NotNull
    private String fromCurrencyIsoCode;
    @NotNull
    private String toCurrencyIsoCode;
    @NotNull
    private LocalDateTime dealTimestamp;
    @NotNull
    private Long dealAmount;

}
