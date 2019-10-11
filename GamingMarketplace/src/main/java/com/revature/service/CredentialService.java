package com.revature.service;

import java.util.List;

import com.revature.dao.CredentialDAO;
import com.revature.dao.CredentialDAOImpl;
import com.revature.model.Credential;
import com.revature.model.Player;

public class CredentialService {
	CredentialDAO credentialDAO = new CredentialDAOImpl();
	// this method returns a list of all activities's
	public List<Credential> getAll(){
		return credentialDAO.getAll();
	}

	// this method returns a row in activity
	public Credential getCredentialById(int credentialId) {
		return credentialDAO.getCredentialById(credentialId);
	}

	// this method adds a row into the credential table
	public boolean addCredential(Credential credential) {
		return credentialDAO.addCredential(credential);
	}

	// this method updates a row in the credential table
	public boolean updateCredential(Credential credential) {
		return credentialDAO.updateCredential(credential);
	}

	// this method deletes a row in the credential table
	public boolean deleteCredential(Credential credential) {
		return credentialDAO.deleteCredential(credential);
	}

	// Returns the player object if the login is successful or null if doesn't match
	public Player login(String username, String password) {
		return credentialDAO.login(username, password);
	}
}
