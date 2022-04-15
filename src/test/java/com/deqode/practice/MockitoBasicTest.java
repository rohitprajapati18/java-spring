package com.deqode.practice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeEach
	void setup() {
		//this.itemService = new ItemService(this.itemRepository, this.customRepository);
	}
	
	@Test
	void BasicTest2() {
		itemService.deleteAllGroceryItems();
		itemService.createGroceryItems();
		
		//
		
		List<GroceryItem> list = new ArrayList<>();
		list.add(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		list.add(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
		list.add(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
		list.add(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
		list.add(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
		
		when(itemRepository.findItemByName("Whole Wheat Biscuit")).thenReturn(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		when(itemRepository.findAll()).thenReturn(list);
		
		GroceryItem g =  itemService.getGroceryItemByName("Whole Wheat Biscuit");
		assertThat(g.getName()).isEqualToIgnoringCase("Whole Wheat Biscuit");
		
		itemService.showAllGroceryItems();
		verify(itemRepository).findAll();
	}
}
