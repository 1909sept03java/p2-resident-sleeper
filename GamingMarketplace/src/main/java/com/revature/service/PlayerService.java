package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bean.Player;
import com.revature.model.dao.PlayerDAO;

@Service
public class PlayerService {
	

	//PlayerDAO playerDAO = new PlayerDAOImpl();
	PlayerDAO playerDAO;
	
	@Autowired
	public PlayerService(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	// this method returns a list of all player's
	public List<Player> getAll(){
		//return playerDAO.getAll();
		return this.playerDAO.getAll();
	}

	// this method returns a row in the player table
	public Player getPlayerById(int playerId) {
		//return playerDAO.getPlayerById();
		return this.playerDAO.getPlayerById(playerId);
	}

	// this method adds a row into the player table
	public boolean addPlayer(Player player) {
		//return playerDAO.addPlayer(player);
		return this.playerDAO.addPlayer(player);
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
