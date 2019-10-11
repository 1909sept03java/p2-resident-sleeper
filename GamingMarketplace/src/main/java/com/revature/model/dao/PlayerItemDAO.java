package com.revature.model.dao;

import java.util.List;

import com.revature.bean.Player;
import com.revature.bean.PlayerItem;

public interface PlayerItemDAO {

	// this method returns a list of all player's
	public List<PlayerItem> getAll();

	// this method returns a row in the player table
	public List<PlayerItem> getAllPlayerItemById(Player player);

	// this method adds a row into the player table
	public boolean addPlayerItem(PlayerItem playerItem);

	// this method updates a row in the player table
	public boolean updatePlayerItem(PlayerItem playerItem);

	// this method deletes a row in the player table
	public boolean deletePlayerItem(PlayerItem playerItem);
}
