package com.revature.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CredentialTest {

	private Credential credential;
	
	@Autowired
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	private Player player;
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Test
	public void test() {
		player = new Player(1, "rex", "cruz", "rex@example", "rex.png", 100, 0);
		credential = new Credential(1, "rex13", "rexpass", player);
		
		//fail("Not yet implemented");
	}

}
