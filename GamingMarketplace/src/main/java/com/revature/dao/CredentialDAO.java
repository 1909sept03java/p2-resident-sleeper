package com.revature.dao;

import java.util.List;

import com.revature.model.Credential;
import com.revature.model.Player;

public interface CredentialDAO {

	// this method returns a list of all the rows in the Credential Table
	public List<Credential> getAll();

	// this method returns a specific row in the Credential Table by credentialId
	public Credential getCredentialById(int credentialId);

	// this method adds a row into the Credential Table
	public boolean addCredential(Credential credential);

	// this method updates a row in the Credential Table
	public boolean updateCredential(Credential credential);

	// this method deletes a row in the Credential Table
	public boolean deleteCredential(Credential credential);

	// if the login username and password exists in the Credential Table, then return the player, else null
	public Player login(String username, String password);
	
	// if the username exists in the Credential Table, return true, else false
	public boolean isUniqueUsername(String username);

}
