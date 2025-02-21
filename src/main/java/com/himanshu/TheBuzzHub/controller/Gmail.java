package com.himanshu.TheBuzzHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.TheBuzzHub.dto.MailData;
import com.himanshu.TheBuzzHub.service.GmailService;
import com.himanshu.TheBuzzHub.utils.CommonResponse;
import com.himanshu.TheBuzzHub.utils.ResponseUtil;

@RestController
@RequestMapping("/Gmail")
public class Gmail {

	@Autowired
	GmailService gmail;

	@Autowired
	ResponseUtil responseutill;

	@PostMapping(value = "/send-mail")
	public ResponseEntity<CommonResponse> sendMail(@RequestBody MailData maildata) {

		return new ResponseEntity<>(ResponseUtil.prepareSuccessResponse(gmail.sendMail(maildata)), HttpStatus.OK);
	}

}
