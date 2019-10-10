package com.revature.model.dao;

import java.util.List;

import com.revature.model.bean.PlayerItem;

public interface PlayerItemDAO {

	// this method returns a list of all player's
	public List<PlayerItem> getAll();

	// this method returns a row in the player table
	public PlayerItem getPlayerItemById();

	// this method adds a row into the player table
	public void addPlayerItem(PlayerItem playerItem);

	// this method updates a row in the player table
	public void updatePlayerItem(PlayerItem playerItem);

	// this method deletes a row in the player table
	public void deletePlayerItem(PlayerItem playerItem);
}
