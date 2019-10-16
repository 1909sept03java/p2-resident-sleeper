package com.revature.dao;

import java.util.List;

import com.revature.model.Item;

public interface ItemDAO {

	// this method returns a list of all the rows in the Item Table
	public List<Item> getAll();

	// this method returns a specific row in the Item Table by itemId
	public Item getItemById(int itemId);

	// this method adds a row into the Item Table
	public boolean addItem(Item item);

	// this method updates a row in the Item Table
	public boolean updateItem(Item item);

	// this method deletes a row in the Item Table
	public boolean deleteItem(Item item);

}
