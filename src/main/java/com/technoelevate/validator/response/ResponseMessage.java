package com.technoelevate.validator.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseMessage {
	private boolean error;
	private String message;
	private Object data;
}
