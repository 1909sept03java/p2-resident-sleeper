package com.revature.dao;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
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
import com.revature.model.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrmConfiguration.class)
public class PlayerDAOImplTest {

	private PlayerDAO playerDAO;
	
	private Player player;
	
	@Autowired
	public void setPlayerDAO(PlayerDAOImpl playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
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
		//System.out.println(playerDAO.toString());
		assertEquals(player, playerDAO.getPlayerById(1));
		
		//fail("Not yet implemented");
	}

}
