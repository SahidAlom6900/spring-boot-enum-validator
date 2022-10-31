package com.technoelevate.validator.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumValidatorRegisterDto implements ConstraintValidator<EnumValidator, Object> {
	private static BiPredicate<? super Enum<?>, String> defaultComparison = (currentEnumValue,
			testValue) -> currentEnumValue.toString().equals(testValue);

	public static void setDefaultEnumComparator(BiPredicate<? super Enum<?>, String> defaultComparison) {
		EnumValidatorRegisterDto.defaultComparison = defaultComparison;
	}

	private Class<? extends Enum<?>> clazz;
	private Enum<?>[] valuesArr;

	@Override
	public void initialize(EnumValidator enumValues) {
		ConstraintValidator.super.initialize(enumValues);
		clazz = enumValues.target();
		valuesArr = clazz.getEnumConstants();
	}

//	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		log.info("" + valuesArr);
		boolean present;
		if (EnumValidatorComparator.class.isAssignableFrom(clazz))
			present = Stream.of(valuesArr).anyMatch(t -> ((EnumValidatorComparator<String>) t).test(value));
		else
			present = Stream.of(valuesArr).anyMatch(t -> defaultComparison.test(t, value));

		if (!present) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					String.format("'%s' is not one of the one of allowable values: '%s'".formatted(value,
							Stream.of(valuesArr).map(Enum::name).toList().toString()))).addConstraintViolation();
		}

		return present;
	}

	@Override
	public boolean isValid(Object values, ConstraintValidatorContext context) {
		List<String> value=new ArrayList<>();
		if (values instanceof String) 
			value.add((String)values);
		else
			value.addAll((List<String>) values);
		return value.stream().filter(t->isValid(t, context)).count()>0;
	}

}
