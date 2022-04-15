package com.deqode.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.deqode.practice.model.GroceryItem;
import com.deqode.practice.service.ItemService;


@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ItemService itemService;
	
	@Test
	public void basicTest1() {
		itemService.deleteAllGroceryItems();
		itemService.createGroceryItems();
		GroceryItem g = itemService.getGroceryItemByName("Whole Wheat Biscuit");
		assertThat(g.getName()).isEqualToIgnoringCase("Whole Wheat Biscuit");
	}
	
	
}
