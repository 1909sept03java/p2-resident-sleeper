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

import com.revature.model.bean.Credential;
import com.revature.model.bean.Player;

@Repository(value = "credentialDAO")
public class CredentialDAOImpl implements CredentialDAO {

	private SessionFactory sf;

	@Autowired // constructor injection
	public CredentialDAOImpl(SessionFactory sf) {
		this.sf = sf;
	}

	// Returns the player object if the login is successful or null if doesn't match
	@Override
	public Player login(String username, String password) {
		Player player = null;
		try (Session s = sf.openSession()) {
			String hql = "SELECT player FROM Credential WHERE username =: username AND password =: password";
			Query query = s.createQuery(hql);
			query.setParameter("username", username.toLowerCase());
			query.setParameter("password", password);
			player = (Player) query.getSingleResult();
			return player;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Credential> getAll() {
		List<Credential> credentialList = new ArrayList<>();
		try (Session s = sf.openSession()) {
			credentialList = s.createQuery("from Credential").getResultList();
		}
		return credentialList;
	}

	@Override
	public Credential getCredentialById(int credentialId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCredential(Credential credential) {
		boolean isAdded = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.save(credential);
			tx.commit();
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public boolean updateCredential(Credential credential) {
		boolean isUpdated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Update Credential Set USERNAME =: username, PASSWORD =: password Where CREDENTIAL_ID =: credentialId";
			Query query = s.createQuery(hql);
			query.setParameter("username", credential.getUsername().toLowerCase());
			query.setParameter("password", credential.getPassword());
			query.setParameter("credentialId", credential.getCredentialId());
			query.executeUpdate();
			tx.commit();
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteCredential(Credential credential) {
		boolean isDeleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Delete from Credential Where CREDENTIAL_ID =: credentialId";
			Query query = s.createQuery(hql);
			query.setParameter("credentialId", credential.getCredentialId());
			query.executeUpdate();
			tx.commit();
			isDeleted = true;
		}
		return isDeleted;
	}

}
