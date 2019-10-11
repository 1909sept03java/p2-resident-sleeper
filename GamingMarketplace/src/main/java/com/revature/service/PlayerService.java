package com.revature.service;

import java.util.List;

import com.revature.dao.PlayerDAO;
import com.revature.dao.PlayerDAOImpl;
import com.revature.model.Player;

public class PlayerService {

	PlayerDAO playerDAO = new PlayerDAOImpl();
	// this method returns a list of all player's
	public List<Player> getAll(){
		return playerDAO.getAll();
	}

	// this method returns a row in the player table
	public Player getPlayerById() {
		return playerDAO.getPlayerById();
	}

	// this method adds a row into the player table
	public boolean addPlayer(Player player) {
		return playerDAO.addPlayer(player);
	}

	// this method updates a row in the player table
	public boolean updatePlayer(Player player) {
		return playerDAO.updatePlayer(player);
	}

	// this method deletes a row in the player table
	public boolean deletePlayer(Player player) {
		return playerDAO.deletePlayer(player);
	}

}
