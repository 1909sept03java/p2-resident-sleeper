package com.revature.dao;

import java.util.List;

import com.revature.model.Player;

public interface PlayerDAO {

	// this method returns a list of all player's
	public List<Player> getAll();

	// this method returns a row in the player table
	public Player getPlayerById(int playerId);

	// this method adds a row into the player table
	public boolean addPlayer(Player player);

	// this method updates a row in the player table
	public boolean updatePlayer(Player player);

	// this method deletes a row in the player table
	public boolean deletePlayer(Player player);

	// this will update the avatar of the player
	public boolean updateAvatar(int playerId, String avatarFilename);

	// this will return true if the email is available in the database
	public boolean isEmailUnique(String email);

}
