package com.revature.dao;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.OrmConfiguration;
import com.revature.model.Credential;
import com.revature.model.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrmConfiguration.class)
public class CredentialDAOImplTest {

	private CredentialDAO credentialDAO;
	
	private Credential cred;
	
	private Player player;
	
	@Autowired
	public void setCredentialDAO(CredentialDAO credentialDAO) {
		this.credentialDAO = credentialDAO;
	}
	
	@Autowired
	public void setCredential(Credential cred) {
		this.cred = cred;
	}
	
	@Autowired
	public void setplayer(Player player) {
		this.player = player;
	}
	

	@Test
	public void test() {
		System.out.println(credentialDAO);
		//setup expected player
		player.setplayerId(1);
		player.setFirstname("rex");
		player.setLastname("cruz");
		player.setEmail("rex@example.com");
		player.setCoins(100);
		player.setAvatarFilename("helmet.jpg");
		player.setMinutes(0);
		//setup expected Credential
		cred.setUsername("rex13");
		cred.setCredentialId(1);
		cred.setPassword("rexpass");
		cred.setPlayer(player);
		
		System.out.println(cred);
		assertEquals(cred, credentialDAO.getCredentialById(1));
		
		//fail("Not yet implemented");
	}

}
