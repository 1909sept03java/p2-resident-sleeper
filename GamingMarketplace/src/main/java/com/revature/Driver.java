package com.revature;

import com.revature.model.Activity;
import com.revature.model.Credential;
import com.revature.model.Item;
import com.revature.model.Player;
import com.revature.model.PlayerItem;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Hello!");

		// creating some model objects
		
		// creating rex with 100 coins and 0 minutes play time Player rex = new
		Player rex = new Player("rex@example.com", "rex", "cruz", "rex.png", 100, 0);
		System.out.println(rex.toString());
		
		// creating credential's for rex
		Credential rexCred = new Credential("rex13", "rexpass", rex);
		System.out.println(rexCred);

		// creating a random item that rex owns
		PlayerItem rexPlayerItem = new PlayerItem("Diamond Sword", 14, "diamondSword.png", false, rex);
		System.out.println(rexPlayerItem);

		// creating a random item in the marketplace
		Item whisperOfTheWyrm = new Item("Whisper of the Wyrm", 12, "whisperOfTheWyrm.png");
		System.out.println(whisperOfTheWyrm);

		// creating a random activity
		Activity rexAct = new Activity("Bought", whisperOfTheWyrm, rex);
		System.out.println(rexAct);
		
		/*
		 * 
		// creating a session factory and a session object for testing
		// using the session factory also creates the tables in the DB
		SessionFactory sf = ConnectionService.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		// adding rex
		//s.save(rex);
		
		// adding rex's credentials
		//s.save(rexCred);
		
		// adding rex's player item
		//s.save(rexPlayerItem);
		
		// adding whisper to the item marketplace
		//s.save(whisperOfTheWyrm);
		
		// adding that rex bought whisper
		//s.save(rexAct);
		
		//tomi - getting information
		Activity tom = s.get(Activity.class, 1);
		System.out.println(tom);
		// committing and releasing resources 
		tx.commit();
		s.close();
		 */

	}

}
