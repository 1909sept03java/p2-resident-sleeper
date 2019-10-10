package com.revature.model.dao;

import com.revature.model.bean.Player;

public interface CredentialDAO {
	//Returns the player object if the login is successful or null if doesn't match
	public Player login(String username, String password);
}
