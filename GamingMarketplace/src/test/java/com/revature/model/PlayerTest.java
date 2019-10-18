package com.revature.model;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PlayerTest {
	
	private Player player;
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Test
	public void test() {
		player = new Player(1, "rex", "cruz", "rex@example", "rex.png", 100, 0);
		System.out.println(player);
		assertNotEquals(player, null); // success
	}

}
