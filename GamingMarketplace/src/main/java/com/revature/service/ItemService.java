package com.revature.service;

import java.util.List;

import com.revature.dao.ItemDAO;
import com.revature.dao.ItemDAOImpl;
import com.revature.model.Item;

public class ItemService {

	ItemDAO itemDAO = new ItemDAOImpl();
	// this method returns a list of all player's
	public List<Item> getAll(){
		return itemDAO.getAll();
	}

	// this method returns a row in the player table
	public Item getItemById() {
		return itemDAO.getItemById();
	}

	// this method adds a row into the player table
	public boolean addItem(Item item) {
		return itemDAO.addItem(item);
	}

	// this method updates a row in the player table
	public boolean updateItem(Item item) {
		return itemDAO.updateItem(item);
	}

	// this method deletes a row in the player table
	public boolean deleteItem(Item item) {
		return itemDAO.deleteItem(item);
	}
}
