package com.technoelevate.validator.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.technoelevate.validator.constants.UserGander.*;
import com.technoelevate.validator.dto.UserDto;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@PostMapping
	public void addUser(@Valid @RequestBody UserDto userDto) {
		System.out.println(userDto.getGander());
		System.out.println(userDto);
	}

}
