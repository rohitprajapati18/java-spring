package com.deqode.practice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Document("BasicUser")
@Data
@ToString
public class BasicUser {
	@Id
	private String id;
	
	private String username;
	private String password;
}
