package com.himanshu.TheBuzzHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.TheBuzzHub.service.RealappServices;

@RestController
@RequestMapping("realapp")
public class RealappApi {

	@Autowired
	RealappServices realapp;

	@GetMapping(value = "cost-center")
	public ResponseEntity<Object> getCostCenter(@RequestParam(value = "le_id", required = true) String le_id,
			@RequestParam(value = "period_name", required = true) String period_name) {
		realapp.getCostCenter(le_id, period_name);

		return new ResponseEntity<>(realapp.getCostCenter(le_id, period_name), HttpStatus.OK);
	}

}
