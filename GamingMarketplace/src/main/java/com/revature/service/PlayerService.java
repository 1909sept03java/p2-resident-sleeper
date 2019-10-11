package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.PlayerDAO;
import com.revature.model.Player;

public class PlayerService {

	private PlayerDAO playerDAO;

	@Autowired
	public PlayerService(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	// this method returns a list of all player's
	public List<Player> getAll() {
		return this.playerDAO.getAll();
	}

	// this method returns a row in the player table
	public Player getPlayerById() {
		return this.playerDAO.getPlayerById();
	}

	// this method adds a row into the player table
	public boolean addPlayer(Player player) {
		return this.playerDAO.addPlayer(player);
	}

	// this method updates a row in the player table
	public boolean updatePlayer(Player player) {
		return this.playerDAO.updatePlayer(player);
	}

	// this method deletes a row in the player table
	public boolean deletePlayer(Player player) {
		return this.playerDAO.deletePlayer(player);
	}

}
