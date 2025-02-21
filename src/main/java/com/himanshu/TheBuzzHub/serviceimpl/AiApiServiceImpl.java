package com.himanshu.TheBuzzHub.serviceimpl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.himanshu.TheBuzzHub.dto.Content;
import com.himanshu.TheBuzzHub.dto.Part;
import com.himanshu.TheBuzzHub.dto.Root;
import com.himanshu.TheBuzzHub.dto.SearchDto;
import com.himanshu.TheBuzzHub.service.AiApiService;

@Service
public class AiApiServiceImpl implements AiApiService {

	@Autowired
	RestTemplate rest;

	@Override
	public Object searchApi(SearchDto searchdto) {
		String jsondata = "";
		Part part = new Part();
		part.setText(searchdto.getSearch());
		ArrayList<Part> partsList = new ArrayList<>();
		partsList.add(part);
		Content content = new Content();
		content.setParts(partsList);
		ArrayList<Content> contentsList = new ArrayList<>();
		contentsList.add(content);
		Root root = new Root();
		root.setContents(contentsList);

		ObjectMapper json = new ObjectMapper();

		try {
			jsondata = json.writeValueAsString(root);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		String url = "";

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<>(jsondata, header);

		ResponseEntity<Object> response = rest.exchange(url, HttpMethod.POST, entity, Object.class);
		Object returnv = response.getBody();

		return returnv;
	}

}
