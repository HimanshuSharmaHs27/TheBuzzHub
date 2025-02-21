package com.himanshu.TheBuzzHub.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Root {

	@JsonProperty(value = "contents")
	public ArrayList<Content> contents;
}
