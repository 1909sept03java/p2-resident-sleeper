package com.revature;

import com.revature.model.Credential;
import com.revature.model.Item;
import com.revature.model.Player;
import com.revature.model.PlayerItem;

public class Driver {

	public static void main(String[] args) {

		// System.out.println("Hello!");
		
		// creating a session factory and a session object for testing
		// SessionFactory sf = ConnectionService.getSessionFactory();
		// Session s = sf.openSession();
		// s.close();
		
		// creating rex with 100 coins and 0 minutes play time
		Player rex = new Player(1,"rex@example.com", "rex", "cruz", "rex.png", 100, 0);
		System.out.println(rex.toString());
		
		// creating credentials for rex
		Credential rexCred = new Credential("rex13", "rexpass", rex);
		System.out.println(rexCred);
		
		// creating a random item that rex owns
		PlayerItem rexPlayerItem = new PlayerItem(1, "Diamond Sword", 14, "diamondSword.png", false, rex);
		System.out.println(rexPlayerItem);
		
		// creating a random item in the marketplace
		Item whisperOfTheWyrm = new Item(1, "Whisper of the Wyrm", 12, "whisperOfTheWyrm.png");
		System.out.println(whisperOfTheWyrm);
		
		
	}

}
