package com.technoelevate.validator.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.technoelevate.validator.constants.UserGander;
import com.technoelevate.validator.utility.EnumValidator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = Include.NON_DEFAULT)
public class UserDto {
	private String name;
//	@NotEmpty
	@NotNull
//	@Enumerated(EnumType.STRING) 
	@EnumValidator(target = UserGander.class)
//	private List<String> gander;
	private String gander;
}
