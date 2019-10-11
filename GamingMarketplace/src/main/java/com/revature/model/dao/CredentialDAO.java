package com.revature.model.dao;

import java.util.List;

import com.revature.bean.Credential;
import com.revature.bean.Player;

public interface CredentialDAO {

	// this method returns a list of all activities's
	public List<Credential> getAll();

	// this method returns a row in activity
	public Credential getCredentialById(int credentialId);

	// this method adds a row into the credential table
	public boolean addCredential(Credential credential);

	// this method updates a row in the credential table
	public boolean updateCredential(Credential credential);

	// this method deletes a row in the credential table
	public boolean deleteCredential(Credential credential);

	// Returns the player object if the login is successful or null if doesn't match
	public Player login(String username, String password);

}
