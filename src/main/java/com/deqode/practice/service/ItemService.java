package com.deqode.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqode.practice.model.GroceryItem;
import com.deqode.practice.repository.CustomItemRepository;
import com.deqode.practice.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository groceryItemRepo;
	
	@Autowired
	CustomItemRepository customRepo;
	
	public ItemService() {
		
	}
	
	public ItemService(ItemRepository item, CustomItemRepository custom) {
		this.groceryItemRepo = item;
		this.customRepo = custom;
	}
	
	List<GroceryItem> itemList = new ArrayList<GroceryItem>();
	
	public void deleteAllGroceryItems() {
		groceryItemRepo.deleteAll();
	}
	
	public void createGroceryItems() {
		System.out.println("Data creation started...");

		groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
		groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
		groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
		groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
		
		System.out.println("Data creation complete...");
	}
	
	public void showAllGroceryItems() {
		 itemList = groceryItemRepo.findAll();
		 itemList.forEach(item -> System.out.println(getItemDetails(item)));
	 }
	 
	 public GroceryItem getGroceryItemByName(String name) {
		 System.out.println("Getting item by name: " + name);
		 GroceryItem item = groceryItemRepo.findItemByName(name);
		 System.out.println(getItemDetails(item));
		 return item;
	 }
	 
	 public void getItemsByCategory(String category) {
		 System.out.println("Getting items for the category " + category);
		 List<GroceryItem> list = groceryItemRepo.findAll(category);
		 
		 list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
	 }
	 
	 public void findCountOfGroceryItems() {
		 long count = groceryItemRepo.count();
		 System.out.println("Number of documents in the collection = " + count);
	 }
	 
	 public void updateCategoryName(String category) {
		 String newCategory = "munchies"; 
		 List<GroceryItem> list = groceryItemRepo.findAll(category);
		 
		 list.forEach(item -> {
			 item.setCategory(newCategory);
		 });
		 
		 List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);
		 
		 if(itemsUpdated != null)
			 System.out.println("Successfully updated " + itemsUpdated.size() + " items.");		 
	 }
	 
	 
	 public void updateItemQuantity(String name, float newQuantity) {
		 System.out.println("Updating quantity for " + name);
		 customRepo.updateItemQuantity(name, newQuantity);
	 }
	 
	 public void deleteGroceryItem(String id) {
		 groceryItemRepo.deleteById(id);
		 System.out.println("Item with id " + id + " deleted...");
	 }
	
	 
	 public String getItemDetails(GroceryItem item) {
		 System.out.println(
		 "Item Name: " + item.getName() + 
		 ", \nItem Quantity: " + item.getQuantity() + 
		 ", \nItem Category: " + item.getCategory()
		 );
		 
		 return "";
	 }
}