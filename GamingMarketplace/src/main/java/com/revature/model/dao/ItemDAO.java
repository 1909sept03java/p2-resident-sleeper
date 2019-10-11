package com.revature.model.dao;

import java.util.List;

import com.revature.bean.Item;

public interface ItemDAO {

	// this method returns a list of all player's
	public List<Item> getAll();

	// this method returns a row in the player table
	public Item getItemById();

	// this method adds a row into the player table
	public boolean addItem(Item item);

	// this method updates a row in the player table
	public boolean updateItem(Item item);

	// this method deletes a row in the player table
	public boolean deleteItem(Item item);

}
