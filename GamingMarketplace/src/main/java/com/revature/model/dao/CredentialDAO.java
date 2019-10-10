package com.revature.model.dao;

import java.util.List;

import com.revature.model.bean.Credential;
import com.revature.model.bean.Player;

public interface CredentialDAO {

	// this method returns a list of all credential's
	public List<Credential> getAll();
	
	// this method returns a row in credential
	public Credential getCredentialById(int credentialId);
	
	// this method returns a row in player by credential id
	public Player getPlayerById(int credentialId);
	
	// this method adds a row into the credential table
	public void addCredential(Credential credential);
	
	// this method updates a row in the credential table
	public void updateCredential(Credential credential);
	
	// this method deletes a row in the credential table
	public void deleteCredential(Credential credential);
	
}
