package com.deqode.practice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deqode.practice.model.GroceryItem;
import com.deqode.practice.repository.CustomItemRepository;
import com.deqode.practice.repository.ItemRepository;
import com.deqode.practice.service.ItemService;

@ExtendWith(MockitoExtension.class)
public class MockitoBasicTest {
	

	
	@Mock private ItemRepository itemRepository;
	@Mock private CustomItemRepository customRepository;
	
	
	@InjectMocks
	private ItemService itemService;
	
	@BeforeEach
	void setup() {
		this.itemService = new ItemService(this.itemRepository, this.customRepository);
	}
	
	@Test
	void BasicTest2() {
		//itemService.deleteAllGroceryItems();
		//itemService.createGroceryItems();
		//GroceryItem g =  itemService.getGroceryItemByName("Whole Wheat Biscuit");
		//assertThat(g.getName()).isEqualToIgnoringCase("Whole Wheat Biscuit");
		itemService.showAllGroceryItems();
		verify(itemRepository).findAll();
	}
}
