package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.PlayerItemDAO;
import com.revature.model.Player;
import com.revature.model.PlayerItem;

public class PlayerItemService {

	private PlayerItemDAO playerItemDAO;

	@Autowired
	public PlayerItemService(PlayerItemDAO playerItemDAO) {
		this.playerItemDAO = playerItemDAO;
	}

	// this method returns a list of all player's
	public List<PlayerItem> getAll() {
		return this.playerItemDAO.getAll();
	}

	// this method returns a row in the player table
	public List<PlayerItem> getAllPlayerItemById(Player player) {
		return this.playerItemDAO.getAllPlayerItemById(player);
	}

	// this method adds a row into the player table
	public boolean addPlayerItem(PlayerItem playerItem) {
		return this.playerItemDAO.addPlayerItem(playerItem);
	}

	// this method updates a row in the player table
	public boolean updatePlayerItem(PlayerItem playerItem) {
		return this.playerItemDAO.updatePlayerItem(playerItem);
	}

	// this method deletes a row in the player table
	public boolean deletePlayerItem(PlayerItem playerItem) {
		return this.playerItemDAO.deletePlayerItem(playerItem);
	}

}
