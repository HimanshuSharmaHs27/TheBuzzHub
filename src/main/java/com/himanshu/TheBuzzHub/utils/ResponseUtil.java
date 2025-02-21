package com.himanshu.TheBuzzHub.utils;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

	public static CommonResponse prepareResponse(Integer status, String message, Object data) {
		return new CommonResponse(LocalDateTime.now(), status, message, data);
	}

	public static CommonResponse prepareSuccessResponse(Object data) {
		CommonResponse commonResponse = new CommonResponse(LocalDateTime.now(), HttpStatus.OK.value(),
				"Request Completed successfully", data);
		return commonResponse;
	}

}
