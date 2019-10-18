package com.revature.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.OrmConfiguration;
import com.revature.dao.PlayerDAO;
import com.revature.model.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrmConfiguration.class)
public class PlayerServiceTest {

	private Player player;
	private PlayerDAO playerDAO;
	
	private PlayerService playerService;
	
	@Autowired
	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Autowired
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
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
		assertEquals(player, playerService.getPlayerById(1));
		//fail("Not yet implemented");
	}

}
