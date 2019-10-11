package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.ItemDAO;
import com.revature.model.Item;

public class ItemService {

	private ItemDAO itemDAO;

	@Autowired
	public ItemService(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	// this method returns a list of all player's
	public List<Item> getAll() {
		return this.itemDAO.getAll();
	}

	// this method returns a row in the player table
	public Item getItemById() {
		return this.itemDAO.getItemById();
	}

	// this method adds a row into the player table
	public boolean addItem(Item item) {
		return this.itemDAO.addItem(item);
	}

	// this method updates a row in the player table
	public boolean updateItem(Item item) {
		return this.itemDAO.updateItem(item);
	}

	// this method deletes a row in the player table
	public boolean deleteItem(Item item) {
		return this.itemDAO.deleteItem(item);
	}

}
