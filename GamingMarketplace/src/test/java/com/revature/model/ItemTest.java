package com.revature.model;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemTest {

	private Item item;

	@Autowired
	public void setItem(Item item) {
		this.item = item;
	}

	@Test
	public void test() {
		item = new Item(1, "sword", 10, "sword.png");
		System.out.println(item);
		assertNotEquals(item, null); // success
	}

}
