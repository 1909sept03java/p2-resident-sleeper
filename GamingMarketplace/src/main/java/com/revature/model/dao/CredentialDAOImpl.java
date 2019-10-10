package com.revature.model.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.bean.Player;
import com.revature.service.ConnectionService;


public class CredentialDAOImpl implements CredentialDAO{
	private SessionFactory sf = ConnectionService.getSessionFactory();

	//.
	//Returns the player object if the login is successful or null if doesn't match
	@Override
	public Player login(String username, String password) {
		Player player = null;
		try (Session s = sf.openSession()) {
			String hql = "SELECT player FROM Credential WHERE username = :username AND password = :password";
			Query query = s.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			player = (Player) query.getSingleResult();
			return player;
		}catch(NoResultException e) {
			return null;
		}
	}

}
