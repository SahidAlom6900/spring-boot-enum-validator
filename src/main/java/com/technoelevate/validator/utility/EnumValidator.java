package com.technoelevate.validator.utility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;


@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@NotNull
@Constraint(validatedBy = {EnumValidatorRegisterDto.class})
public @interface EnumValidator {

    String message() default "Value is not present in enum list.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public String detailMessage() default "";

    public Class<? extends Enum<?>> target();
}