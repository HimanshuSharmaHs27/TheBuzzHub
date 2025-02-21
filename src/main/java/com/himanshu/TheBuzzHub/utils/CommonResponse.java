package com.himanshu.TheBuzzHub.utils;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CommonResponse {

	private LocalDateTime timestamp;
	private Integer status;
	private String message;
	private Object data;

}
