package com.himanshu.TheBuzzHub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Part {

	@JsonProperty(value = "text")
	public String text;
}