package com.revature.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.bean.Player;
import com.revature.model.bean.PlayerItem;


@Repository(value = "playerItemDAO")
public class PlayerItemDAOImpl implements PlayerItemDAO {
	
	private SessionFactory sf;

	@Autowired // constructor injection
	public PlayerItemDAOImpl(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public List<PlayerItem> getAll() {
		List<PlayerItem> playerItemList = new ArrayList<>();
		try (Session s = sf.openSession()) {
			playerItemList = s.createQuery("from PlayerItem").getResultList();
		}
		return playerItemList;
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
	public boolean addPlayerItem(PlayerItem playerItem) {
		boolean isAdded = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.save(playerItem);
			tx.commit();
			isAdded = true;
		}
		return isAdded;	
	}

	@Override
	public boolean updatePlayerItem(PlayerItem playerItem) {
		boolean isUpdated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Update PlayerItem Set NAME =: name, VALUE =: value, ITEM_FILENAME =: itemFilename, FOR_SALE =: forSale, PLAYER_ID =: playerId Where PLAYER_ITEM_ID =: playerItemId";
			Query query = s.createQuery(hql);
			query.setParameter("name", playerItem.getName());
			query.setParameter("value", playerItem.getValue());
			query.setParameter("itemFilename", playerItem.getItemFilename());
			query.setParameter("forSale", playerItem.isForSale());
			query.setParameter("playerId", playerItem.getPlayer().getplayerId());
			query.executeUpdate();
			tx.commit();
			isUpdated = true;
		}
		return isUpdated;		
	}

	@Override
	public boolean deletePlayerItem(PlayerItem playerItem) {
		boolean isDeleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Delete from PlayerItem Where PLAYER_ITEM_ID =: playerId";
			Query query = s.createQuery(hql);
			query.setParameter("playerItemId", playerItem.getPlayerItemId());
			query.executeUpdate();
			tx.commit();
			isDeleted = true;
		}
		return isDeleted;
	}

}
