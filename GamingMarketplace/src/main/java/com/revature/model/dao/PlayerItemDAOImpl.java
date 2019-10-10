package com.revature.model.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.bean.Player;
import com.revature.model.bean.PlayerItem;
import com.revature.service.ConnectionService;

public class PlayerItemDAOImpl implements PlayerItemDAO {
	
	private SessionFactory sf = ConnectionService.getSessionFactory();

	@Override
	public List<PlayerItem> getAll() {
		List<PlayerItem> playerItemList = null;
		try (Session s = sf.openSession()) {
			String hql = "SELECT * FROM PlayerItem";
			Query query = s.createQuery(hql);
			playerItemList = query.getResultList();
			return playerItemList;
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public List<PlayerItem> getAllPlayerItemById(Player player) {
		int playerId = player.getplayerId();
		List<PlayerItem> playerItemList = null;
		try (Session s = sf.openSession()) {
			String hql = "SELECT * FROM PlayerItem WHERE PLAYER_ID = :playerId";
			Query query = s.createQuery(hql);
			query.setParameter("playerId", playerId);
			playerItemList = query.getResultList();
			return playerItemList;
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public void addPlayerItem(PlayerItem playerItem) {
	}

	@Override
	public void updatePlayerItem(PlayerItem playerItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlayerItem(PlayerItem playerItem) {
		// TODO Auto-generated method stub
		
	}

}
