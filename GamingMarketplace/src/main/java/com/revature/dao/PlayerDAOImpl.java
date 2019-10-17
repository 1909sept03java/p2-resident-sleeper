package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Activity;
import com.revature.model.Item;
import com.revature.model.Player;
import com.revature.model.PlayerItem;;

@Repository(value = "playerDAO")
public class PlayerDAOImpl implements PlayerDAO {

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
	public Player getPlayerById(int playerId) {
		// modified by Tomi to build PlayerService function
		try (Session s = sf.openSession()) {
			Player player = s.get(Player.class, playerId);
			System.out.println(s.getStatistics());
		}
		Session s = sf.openSession();
		Player player = s.get(Player.class, playerId);
		s.close();
		return player;
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

	@Override
	public boolean updateAvatar(int playerId, String avatarFilename) {
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			Player player = s.get(Player.class, playerId);
			String hql = "Update Player Set AVATAR_FILENAME =: avatarFilename Where PLAYER_ID =: playerId";
			Query query = s.createQuery(hql);
			query.setParameter("avatarFilename", avatarFilename);
			query.setParameter("playerId", playerId);
			query.executeUpdate();
			tx.commit();
			s.close();
			return true;
		}catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean isEmailUnique(String email) {
		Player player = null;
		try (Session s = sf.openSession()) {
			String hql = "from Player where EMAIL =: email";
			Query query = s.createQuery(hql);
			query.setParameter("email", email.toLowerCase());
			player = (Player) query.getSingleResult();
			s.close();
			return true;
		}catch(NoResultException e) {
			return false;
		} catch (NonUniqueResultException e) {
			return false;
		}
	}

	//.
	//this will deduct the balance and also update the PlayerItem table
	@Override
	public boolean deductBalance(int playerId, int itemId) {
		Player player = null;
		Item item = null;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			player = s.get(Player.class, playerId);
			item = s.get(Item.class, itemId);
			String hql = "Update Player Set COINS =: coins Where PLAYER_ID =: playerId";
			Query query = s.createQuery(hql);
			query.setParameter("playerId", playerId);
			query.setParameter("coins", (player.getCoins()-item.getValue()));
			query.executeUpdate();
			PlayerItem playerItem  = new PlayerItem();
			playerItem.setItem(item);
			playerItem.setForSale(true);
			//playerItem.setItemFilename(item.getItemFilename());
			//playerItem.setName(item.getName());
			playerItem.setPlayer(player);
			//playerItem.setValue(item.getValue());
			s.save(playerItem);
			Activity activity = new Activity();
			activity.setItem(item);
			activity.setPlayer(player);
			activity.setType("Bought");
			s.save(activity);
			tx.commit();
			s.close();
			return true;

		}catch (Exception e) {
			return false;
		}

	}

}
