package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.Credential;
import com.revature.model.Player;
import com.revature.service.ConnectionService;

public class Driver {

	public static void main(String[] args) {

		// System.out.println("Hello!");
		
		// creating a session factory and a session object for testing
		SessionFactory sf = ConnectionService.getSessionFactory();
		Session s = sf.openSession();
		
		// creating rex with 100 coins and 0 minutes play time
		Player rex = new Player(1,"rex@example.com", "rex", "cruz", "rex.png", 100, 0);
		System.out.println(rex.toString());
		
		// creating credentials for rex
		Credential rexCred = new Credential("rex13", "rexpass", rex);
		System.out.println(rexCred);
		
		s.close();
	}

}
