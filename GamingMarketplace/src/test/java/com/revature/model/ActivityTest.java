package com.revature.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityTest {

	private Activity activity;
	
	private Player player;
	
	private Item item;
	
	@Autowired
	public void setActivity(Activity act) {
		this.activity = act;
	}
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Autowired
	public void setItem(Item item) {
		this.item = item;
	}

	@Test
	public void test() {
		player = new Player(21, "rex", "cruz", "rex@example", "rex.png", 100, 0);
		item = new Item(23, "diamondSword.png", 14, "Diamond Sword");
		activity = new Activity(21, "Bought", item, player);
		System.out.println(activity);
		assertNotEquals(activity, null); // success
		//fail("Not yet implemented");
	}

}
