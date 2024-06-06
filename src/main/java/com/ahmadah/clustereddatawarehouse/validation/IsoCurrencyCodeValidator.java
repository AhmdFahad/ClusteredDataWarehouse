package com.ahmadah.clustereddatawarehouse.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Currency;
import java.util.Set;
import java.util.stream.Collectors;

public class IsoCurrencyCodeValidator implements ConstraintValidator<IsoCurrencyCode, String> {

    private Set<String> isoCurrencies;

    @Override
    public void initialize(IsoCurrencyCode constraintAnnotation) {
        isoCurrencies = Currency.getAvailableCurrencies().stream()
                .map(Currency::getCurrencyCode)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return isoCurrencies.contains(value);
    }
}
