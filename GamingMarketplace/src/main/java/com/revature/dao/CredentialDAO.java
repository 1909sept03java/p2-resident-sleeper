package com.revature.dao;

import java.util.List;

<<<<<<< HEAD:GamingMarketplace/src/main/java/com/revature/dao/CredentialDAO.java
import com.revature.model.Credential;
import com.revature.model.Player;
=======
import com.revature.bean.Credential;
import com.revature.bean.Player;
>>>>>>> service_classes:GamingMarketplace/src/main/java/com/revature/model/dao/CredentialDAO.java

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
