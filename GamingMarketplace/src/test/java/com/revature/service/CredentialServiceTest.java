package com.revature.service;

import static org.junit.Assert.assertEquals;

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
public class CredentialServiceTest {

	private Player player;
	
	private Credential cred;
	
	private CredentialService credentialService;
	
	@Autowired
	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
		
	@Autowired
	public void setCredential(Credential cred) {
		this.cred = cred;
	}
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}
	

	@Test
	public void test() {
		System.out.println(cred);
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
		
		assertEquals(cred, credentialService.getCredentialById(1));
		
		//fail("Not yet implemented");
	}

}
