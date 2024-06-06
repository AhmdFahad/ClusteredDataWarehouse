package com.ahmadah.clustereddatawarehouse.model;

import com.ahmadah.clustereddatawarehouse.validation.IsoCurrencyCode;
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
    @IsoCurrencyCode
    private String fromCurrencyIsoCode;
    @NotNull
    @IsoCurrencyCode
    private String toCurrencyIsoCode;
    @NotNull
    private LocalDateTime dealTimestamp;
    @NotNull
    private Long dealAmount;

}
