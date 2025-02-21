package com.himanshu.TheBuzzHub.serviceimpl;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.himanshu.TheBuzzHub.service.RealappServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RealappServicesImpl implements RealappServices {

	@Autowired
	RestTemplate rest;

	@Override
	public Object getCostCenter(String le_id, String period_name) {

		String finalurl = "";
		String key = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSRUFMQVBQQENPTk5BSVNTQU5ULkNPTSIsImlhdCI6MTczODU4MTUxOCwiZXhwIjoxNzQwMzgxNTE4fQ.nFOPQHyiqk8c9ZacDng8ftg_rYH9ukbyZOXKJ7iBJ5MZ290sFavixw1YcPnSXBRTbHpwJyX0efdC2PZZ7Uhfqw";
		String URL = "https://realappdev.delhivery.com:8080/realapp/fc-billing/get-cost-center?_page=0&_limit=10";

		try {
			URIBuilder uriBuilder = new URIBuilder(URL);
			uriBuilder.addParameter("le_id", le_id);
			uriBuilder.addParameter("period_name", period_name);
			finalurl = uriBuilder.build().toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		log.info(finalurl);
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		header.add("Authorization","Bearer "+key);

		HttpEntity<String> entity = new HttpEntity<>(header);

		ResponseEntity<Object> response = rest.exchange(finalurl, HttpMethod.GET, entity, Object.class);
		Object response2 = response.getBody();

		return response2;
	}

}
