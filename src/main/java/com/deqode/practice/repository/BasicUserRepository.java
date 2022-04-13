package com.deqode.practice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.deqode.practice.model.BasicUser;
import com.deqode.practice.model.GroceryItem;

public interface BasicUserRepository extends MongoRepository<BasicUser, String>{
	@Query(value="{username:'?0'}", fields="{'username' : 1, 'password' : 1}")
	BasicUser findByUsername(String username);
}
