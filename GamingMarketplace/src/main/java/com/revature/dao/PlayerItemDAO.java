package com.revature.dao;

import java.util.List;

import com.revature.model.Player;
import com.revature.model.PlayerItem;

public interface PlayerItemDAO {

	// this method returns a list of all player's
	public List<PlayerItem> getAll();

	// this method returns a list of row in the player table
	public List<PlayerItem> getAllPlayerItemById(Player player);

	// this method returns a single row
	public PlayerItem getPlayerItemById(int playerItemId);
	
	// this method adds a row into the player table
	public boolean addPlayerItem(PlayerItem playerItem);

	// this method updates a row in the player table
	public boolean updatePlayerItem(PlayerItem playerItem);

	// this method deletes a row in the player table
	public boolean deletePlayerItem(PlayerItem playerItem);
	
	//this will return the list of the items owned by a player
	public List<PlayerItem> getSpecific(int playerId);
	
}

