package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.CredentialDAO;
import com.revature.model.Credential;
import com.revature.model.Player;

public class CredentialService {

	private CredentialDAO credentialDAO;

	@Autowired
	public CredentialService(CredentialDAO credentialDAO) {
		this.credentialDAO = credentialDAO;
	}

	// this method returns a list of all activities's
	public List<Credential> getAll() {
		return this.credentialDAO.getAll();
	}

	// this method returns a row in activity
	public Credential getCredentialById(int credentialId) {
		return this.credentialDAO.getCredentialById(credentialId);
	}

	// this method adds a row into the credential table
	public boolean addCredential(Credential credential) {
		return this.credentialDAO.addCredential(credential);
	}

	// this method updates a row in the credential table
	public boolean updateCredential(Credential credential) {
		return this.credentialDAO.updateCredential(credential);
	}

	// this method deletes a row in the credential table
	public boolean deleteCredential(Credential credential) {
		return this.credentialDAO.deleteCredential(credential);
	}

	// Returns the player object if the login is successful or null if doesn't match
	public Player login(String username, String password) {
		return this.credentialDAO.login(username, password);
	}

}