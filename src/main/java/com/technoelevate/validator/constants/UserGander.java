package com.technoelevate.validator.constants;

import com.technoelevate.validator.utility.EnumValidatorComparator;

public enum UserGander implements EnumValidatorComparator<String>{
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other");
	
	private final String field;

	private UserGander(String field) {
		this.field = field;
	}

	public String getField() {
		return field;
	}

	@Override
	public boolean test(String object) {
		return this.field.equalsIgnoreCase(object);
	}
}
