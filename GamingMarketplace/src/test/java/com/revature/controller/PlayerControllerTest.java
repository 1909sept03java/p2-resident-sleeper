package com.revature.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.OrmConfiguration;
import com.revature.model.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrmConfiguration.class)
public class PlayerControllerTest {
	
	private PlayerController playerController;
	
	private Player player;
	
	//private ResponseEntity<Player>;
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Autowired
	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}

	

	

	@Test
	public void test() {
		//setup expected player
		player.setplayerId(1);
		player.setFirstname("rex");
		player.setLastname("cruz");
		player.setEmail("rex@example.com");
		player.setCoins(100);
		player.setAvatarFilename("helmet.jpg");
		player.setMinutes(0);
		System.out.println(player);	
		
		assertThat(playerController, instanceOf(PlayerController.class));
		//fail("Not yet implemented");
	}

}
