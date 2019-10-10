package com.revature.model.service;

import java.util.List;

import com.revature.model.bean.Player;
import com.revature.model.bean.PlayerItem;
import com.revature.model.dao.PlayerItemDAO;
import com.revature.model.dao.PlayerItemDAOImpl;

public class PlayerItemService {
	PlayerItemDAO playerItemDAO = new PlayerItemDAOImpl();
	// this method returns a list of all player's
		public List<PlayerItem> getAll(){
			return playerItemDAO.getAll();
		}

		// this method returns a row in the player table
		public List<PlayerItem> getAllPlayerItemById(Player player){
			return playerItemDAO.getAllPlayerItemById(player);
		}

		// this method adds a row into the player table
		public boolean addPlayerItem(PlayerItem playerItem) {
			return playerItemDAO.addPlayerItem(playerItem);
		}

		// this method updates a row in the player table
		public boolean updatePlayerItem(PlayerItem playerItem) {
			return playerItemDAO.updatePlayerItem(playerItem);
		}

		// this method deletes a row in the player table
		public boolean deletePlayerItem(PlayerItem playerItem) {
			return playerItemDAO.deletePlayerItem(playerItem);
		}
}
