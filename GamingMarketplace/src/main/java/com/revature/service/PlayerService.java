package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PlayerDAO;
import com.revature.model.Player;

@Service
public class PlayerService {

	private PlayerDAO playerDAO;

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
		return this.playerDAO.updatePlayer(player);
	}

	// this method deletes a row in the player table
	public boolean deletePlayer(Player player) {
		return this.playerDAO.deletePlayer(player);
	}

	//.
	//this will update the avatar of the
	public boolean updateAvatar(int playerId,String avatarFilename) {
		return this.playerDAO.updateAvatar(playerId, avatarFilename);
	}

	//.
	//this will return true if the email is available in the database
	public boolean isEmailUnique(String email) {
		return this.playerDAO.isEmailUnique(email);
	}

	//.
	//this will deduct the balance and also update the PlayerItem and Activity table
	public boolean deductBalance(int playerId, int itemId) {
		return this.playerDAO.deductBalance(playerId, itemId);
	}

	//.
	//this will update the balance after logout
	public boolean balanceAfterLogout(int playerId, int coins) {
		return this.playerDAO.balanceAfterLogout(playerId, coins);
	}
	//.
	//this will update the balance and also update the PlayerItem and Activity table
	public boolean updateAfterSell(int activityId) {
		return this.playerDAO.updateAfterSell(activityId);
	}
}

