package com.revature.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.bean.Player;

@Repository(value = "playerDAO")
public class PlayerDAOImpl implements PlayerDAO {
	
	public PlayerDAOImpl() {
		super();
	}

	private SessionFactory sf;

	@Autowired // constructor injection
	public PlayerDAOImpl(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<Player> getAll() {
		List<Player> playerList = new ArrayList<>();
		try (Session s = sf.openSession()) {
			playerList = s.createQuery("from Player").getResultList();
		}
		return playerList;
	}

	@Override
	public Player getPlayerById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPlayer(Player player) {
		boolean isAdded = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.save(player);
			tx.commit();
			isAdded = true;
		}
		return isAdded;		
	}

	@Override
	public boolean updatePlayer(Player player) {
		boolean isUpdated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Update Player Set EMAIL =: email, FIRSTNAME =: firstname, LASTNAME =: lastname, AVATAR_FILENAME =: avatarFilename, COINS =: coins, MINTES =: minutes Where PLAYER_ID =: playerId";
			Query query = s.createQuery(hql);
			query.setParameter("email", player.getEmail());
			query.setParameter("firstname", player.getFirstname());
			query.setParameter("lastname", player.getLastname());
			query.setParameter("avatarFilename", player.getAvatarFilename());
			query.setParameter("coins", player.getCoins());
			query.setParameter("minutes", player.getMinutes());
			query.setParameter("playerId", player.getplayerId());
			query.executeUpdate();
			tx.commit();
			isUpdated = true;
		}
		return isUpdated;		
	}

	@Override
	public boolean deletePlayer(Player player) {
		boolean isDeleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Delete from Player Where PLAYER_ID =: playerId";
			Query query = s.createQuery(hql);
			query.setParameter("playerId", player.getplayerId());
			query.executeUpdate();
			tx.commit();
			isDeleted = true;
		}
		return isDeleted;
	}

}
