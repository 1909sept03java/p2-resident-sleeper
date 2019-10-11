package com.revature.dao;

import java.util.List;

import com.revature.model.Player;

public interface PlayerDAO {

	// this method returns a list of all player's
	public List<Player> getAll();
	
	// this method returns a row in the player table
	public Player getPlayerById();

	// this method adds a row into the player table
	public boolean addPlayer(Player player);

	// this method updates a row in the player table
	public boolean updatePlayer(Player player);

	// this method deletes a row in the player table
	public boolean deletePlayer(Player player);
	
}