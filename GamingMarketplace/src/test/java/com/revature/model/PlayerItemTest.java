package com.revature.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerItemTest {

	private Item item;
	
	private PlayerItem playerItem;
	
	private Player player;

	@Autowired
	public void setItem(Item item) {
		this.item = item;
	}
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}
	@Autowired
	public void setPlayerItem(PlayerItem playerItem) {
		this.playerItem = playerItem;
	}

	@Test
	public void test() {
		player = new Player(1, "rex", "cruz", "rex@example", "rex.png", 100, 0);
		item = new Item(3, "Diamond Armor", 15, "diamondArmor.png");
		System.out.println(player);
		playerItem = new PlayerItem(1, false, item, player);
		assertNotEquals(playerItem, null); // success
		//fail("Not yet implemented");
	}

}
