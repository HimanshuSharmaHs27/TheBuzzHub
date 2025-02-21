package com.himanshu.TheBuzzHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.TheBuzzHub.dto.SearchDto;
import com.himanshu.TheBuzzHub.service.AiApiService;

@RestController
@RequestMapping("/Gpt")
public class AiApi {

	@Autowired
	AiApiService aiapi;

	@PostMapping(value = "/search")
	public ResponseEntity<Object> searchApi(@RequestBody SearchDto searchdto) {
		System.out.println(searchdto.getSearch());
		Object api = aiapi.searchApi(searchdto);
		System.out.println(api);
		return new ResponseEntity<>(api, HttpStatus.OK);
	}

}
