package com.revature.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.PlayerDAO;
import com.revature.model.Player;

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
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//System.out.println("PlayerService is : "+playerService+" instance of: "+instanceOf(PlayerService.class));
		//assertThat(playerService, instanceOf(PlayerService.class));
		PlayerService playerService2 = (PlayerService) ac.getBean("PlayerService");
		System.out.println("PlayerService is : "+playerService2+" instance of: "+instanceOf(PlayerService.class));
		//player = new Player(1, "rex", "cruz", "rex@example", "rex.png", 100, 0);
		//System.out.println("Player is : "+player+" instance of: "+instanceOf(Player.class));
		//assertThat(player, instanceOf(Player.class));
		//assertEquals(player, playerService2.getPlayerById(1));
		//fail("Not yet implemented");
		ac.close();
	}

}
