package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.bean.Credential;
import com.revature.model.bean.Player;
import com.revature.model.dao.CredentialDAO;
import com.revature.model.dao.CredentialDAOImpl;
import com.revature.service.ConnectionService;

public class Driver {

	public static void main(String[] args) {

		// System.out.println("Hello!");

		// creating a session factory and a session object for testing
		// using the session factory also creates the tables in the DB
//		SessionFactory sf = ConnectionService.getSessionFactory();
//		Session sess = sf.openSession();
//		sess.close();


		// creating a random item that rex owns
		//PlayerItem rexPlayerItem = new PlayerItem(1, "Diamond Sword", 14, "diamondSword.png", false, rex);
		//System.out.println(rexPlayerItem);

		// creating a random item in the marketplace
		//Item whisperOfTheWyrm = new Item(1, "Whisper of the Wyrm", 12, "whisperOfTheWyrm.png");
		//System.out.println(whisperOfTheWyrm);

		// creating a random activity
		//Activity rexAct = new Activity(1, "Bought", whisperOfTheWyrm, rex);
		//System.out.println(rexAct);

		/*
		 * 
		SessionFactory sf = ConnectionService.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		// creating rex with 100 coins and 0 minutes play time
		Player rex = new Player("rex@example.com", "rex", "cruz", "rex.png", 100, 0);
		System.out.println(rex.toString());
		
		s.persist(rex);
		tx.commit();
		
		
		// creating credentials for rex
		Credential rexCred = new Credential("rex13", "rexpass", rex);
		System.out.println(rexCred);
		
		
		s.close();
		 */
		
		String username = "rex13";
		String password = "rexpass";
		CredentialDAO credentialDAO = new CredentialDAOImpl();
		//System.out.println(credentialDAO.login(username, password).toString());
		
		Player rex = new Player(7, "rex@example.com", "rex", "cruz", "rex.png", 100, 0);
		System.out.println(rex.toString());
		
		Credential rexCred = new Credential(18, "rex14", "rexpass", rex);
		System.out.println(rexCred);
		
		credentialDAO.deleteCredential(rexCred);
		
		System.out.println(credentialDAO.getAll());
		
	}

}
