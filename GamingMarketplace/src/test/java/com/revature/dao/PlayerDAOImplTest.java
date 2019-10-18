package com.revature.dao;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Player;

public class PlayerDAOImplTest {

	//private PlayerDAO playerDAO;
	
	private Player player;
	
	private SessionFactory sf;
	
	private AbstractApplicationContext ac = new ClassPathXmlApplicationContext("src/main/webapp/applicationContext.xml");
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	PlayerDAO playerDAO = (PlayerDAO) ac.getBean("playerDAO");
//	@Autowired
//	public void setPlayerDAO(PlayerDAOImpl playerDAO) {
//		this.playerDAO = playerDAO;
//	}
	
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Test
	public void test() {
		player = new Player(1, "rex", "cruz", "rex@example", "rex.png", 100, 0);
		System.out.println(player);				
		System.out.println(playerDAO.toString());
		//assertEquals(player, playerDAO.getPlayerById(1));
		
		//fail("Not yet implemented");
	}

}
