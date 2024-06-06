package com.ahmadah.clustereddatawarehouse.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsoCurrencyCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsoCurrencyCode {
    String message() default "Invalid ISO 4217 currency code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
