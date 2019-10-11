package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

import com.revature.dao.PlayerDAO;
import com.revature.model.Player;

public class PlayerService {

	private PlayerDAO playerDAO;

=======
import org.springframework.stereotype.Service;

<<<<<<<< HEAD:GamingMarketplace/src/main/java/com/revature/service/PlayerService.java
import com.revature.bean.Player;
import com.revature.model.dao.PlayerDAO;
========
import com.revature.dao.PlayerDAO;
import com.revature.model.Player;
>>>>>>>> service_classes:GamingMarketplace/src/main/java/com/revature/model/service/PlayerService.java

@Service
public class PlayerService {
	

	//PlayerDAO playerDAO = new PlayerDAOImpl();
	PlayerDAO playerDAO;
	
>>>>>>> service_classes
	@Autowired
	public PlayerService(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
<<<<<<< HEAD

	// this method returns a list of all player's
	public List<Player> getAll() {
=======
	
	// this method returns a list of all player's
	public List<Player> getAll(){
		//return playerDAO.getAll();
>>>>>>> service_classes
		return this.playerDAO.getAll();
	}

	// this method returns a row in the player table
	public Player getPlayerById(int playerId) {
		//return playerDAO.getPlayerById();
		return this.playerDAO.getPlayerById(playerId);
	}

	// this method adds a row into the player table
	public boolean addPlayer(Player player) {
<<<<<<< HEAD
=======
		//return playerDAO.addPlayer(player);
>>>>>>> service_classes
		return this.playerDAO.addPlayer(player);
	}

	// this method updates a row in the player table
	public boolean updatePlayer(Player player) {
<<<<<<< HEAD
		return this.playerDAO.updatePlayer(player);
=======
		return playerDAO.updatePlayer(player);
>>>>>>> service_classes
	}

	// this method deletes a row in the player table
	public boolean deletePlayer(Player player) {
<<<<<<< HEAD
		return this.playerDAO.deletePlayer(player);
=======
		return playerDAO.deletePlayer(player);
>>>>>>> service_classes
	}

}
