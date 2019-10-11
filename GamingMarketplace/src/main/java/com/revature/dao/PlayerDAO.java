package com.revature.dao;

import java.util.List;

<<<<<<< HEAD:GamingMarketplace/src/main/java/com/revature/dao/PlayerDAO.java
import com.revature.model.Player;
=======
import com.revature.bean.Player;
>>>>>>> service_classes:GamingMarketplace/src/main/java/com/revature/model/dao/PlayerDAO.java

public interface PlayerDAO {

	// this method returns a list of all player's
	public List<Player> getAll();
	
	// this method returns a row in the player table
	//modified by Tomi
	public Player getPlayerById(int playerId);

	// this method adds a row into the player table
	public boolean addPlayer(Player player);

	// this method updates a row in the player table
	public boolean updatePlayer(Player player);

	// this method deletes a row in the player table
	public boolean deletePlayer(Player player);
	
}
