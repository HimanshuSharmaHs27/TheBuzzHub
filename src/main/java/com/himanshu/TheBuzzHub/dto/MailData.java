package com.himanshu.TheBuzzHub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailData {

	@JsonProperty("To")
	private String to;

	@JsonProperty("Subject")
	private String subject;

	@JsonProperty("Body")
	private String body;

}
