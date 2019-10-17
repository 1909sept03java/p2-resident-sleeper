package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.Activity;
import com.revature.model.Credential;
import com.revature.model.Item;
import com.revature.model.Player;
import com.revature.model.PlayerItem;
import com.revature.service.ConnectionService;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Hello!");

		// creating some model objects

		// creating rex with 100 coins and 0 minutes play time Player rex = new
		Player rex = new Player("rex@example.com", "rex", "cruz", "helmet.jpg", 100, 0);
		System.out.println(rex.toString());

		Player gurvir = new Player("gurvir@example.com", "gurvir", "singh", "whisperOfTheWyrm.jpg", 100, 0);
		System.out.println(gurvir.toString());

		Player sudipta = new Player("sudipta@example.com", "sudipta", "saha", "redBall.jpg", 100, 0);
		System.out.println(sudipta.toString());

		Player tomi = new Player("tomi@example.com", "tomi", "adegbenro", "unhappy.png", 100, 0);
		System.out.println(tomi.toString());

		// creating credential's for rex
		Credential rexCred = new Credential("rex13", "rexpass", rex);
		System.out.println(rexCred);

		Credential gurvirCred = new Credential("gurvir14", "gurvirpass", gurvir);
		System.out.println(gurvirCred.toString());

		Credential sudiptaCred = new Credential("sudipta15", "sudiptapass", sudipta);
		System.out.println(sudiptaCred.toString());

		Credential tomiCred = new Credential("tomi16", "tomipass", tomi);
		System.out.println(tomiCred.toString());

		// creating a random item in the marketplace
		Item oblivionAndOathKeeper = new Item("Oblivion and Oathkeeper", 20, "oblivionAndOathkeeper.png");
		System.out.println(oblivionAndOathKeeper);
		Item diamondArmor = new Item("Diamond Armor", 15, "diamondArmor.png");
		System.out.println(diamondArmor);
		Item diamondSword = new Item("Diamond Sword", 14, "diamondSword.jpg");
		System.out.println(diamondSword);
		Item paintBrush = new Item("Paint Brush", 13, "paintBrush.png");
		System.out.println(paintBrush);
		Item redX = new Item("redX", 30, "redX.jpg");
		System.out.println(redX);

		Item unhappyFaceBall = new Item("Unhappy Face Ball", 9, "unhappy.png");
		System.out.println(unhappyFaceBall);
		Item greenBall = new Item("Green Ball", 10, "greenBall.jpg");
		System.out.println(greenBall);
		Item redBall = new Item("Red Ball", 11, "redBall.jpg");
		System.out.println(redBall);
		Item earthBall = new Item("Earth Ball", 8, "earthBall.png");
		System.out.println(earthBall);
		Item plasmaBall = new Item("Plasma Ball", 15, "plasmaBall.jpg");
		System.out.println(plasmaBall);

		Item whisperOfTheWyrm = new Item("Whisper of the Wyrm", 22, "whisperOfTheWyrm.jpg");
		System.out.println(whisperOfTheWyrm);
		Item claw = new Item("Claw", 10, "claw.png");
		System.out.println(claw);
		Item helmet = new Item("Helmet", 14, "helmet.jpg");
		System.out.println(helmet);
		Item bat = new Item("neil's Bat", 15, "neilBat.jpg");
		System.out.println(bat);
		Item gloves = new Item("Gloves", 8, "gloves.jpg");
		System.out.println(gloves);

		// creating a random item that rex owns
		PlayerItem rexPlayerItem = new PlayerItem(false, diamondSword, rex);
		System.out.println(rexPlayerItem);
		PlayerItem rexPlayerItem2 = new PlayerItem(false, diamondArmor, rex);
		System.out.println(rexPlayerItem2);
		PlayerItem rexPlayerItem3 = new PlayerItem(false, oblivionAndOathKeeper, rex);
		System.out.println(rexPlayerItem3);

		PlayerItem gurvirPlayerItem = new PlayerItem(false, bat, gurvir);
		System.out.println(gurvirPlayerItem);
		PlayerItem gurvirPlayerItem2 = new PlayerItem(false, claw, gurvir);
		System.out.println(gurvirPlayerItem2);
		PlayerItem gurvirPlayerItem3 = new PlayerItem(false, whisperOfTheWyrm, gurvir);
		System.out.println(gurvirPlayerItem3);

		PlayerItem sudiptaPlayerItem = new PlayerItem(false, unhappyFaceBall, sudipta);
		System.out.println(sudiptaPlayerItem);
		PlayerItem sudiptaPlayerItem2 = new PlayerItem(false, greenBall, sudipta);
		System.out.println(sudiptaPlayerItem2);
		PlayerItem sudiptaPlayerItem3 = new PlayerItem(false, earthBall, sudipta);
		System.out.println(sudiptaPlayerItem3);

		PlayerItem tomiPlayerItem = new PlayerItem(false, new Item("tomiItem1", 5, "tomiItem1.png"), tomi);
		System.out.println(tomiPlayerItem);
		PlayerItem tomiPlayerItem2 = new PlayerItem(false, new Item("tomiItem2", 5, "tomiItem2.png"), tomi);
		System.out.println(tomiPlayerItem2);
		PlayerItem tomiPlayerItem3 = new PlayerItem(false, new Item("tomiItem3", 5, "tomiItem3.png"), tomi);
		System.out.println(tomiPlayerItem3);

		// creating a random activity
		Activity rexAct = new Activity("Bought", diamondSword, rex);
		System.out.println(rexAct);
		Activity rexAct2 = new Activity("Bought", diamondArmor, rex);
		System.out.println(rexAct2);
		Activity rexAct3 = new Activity("Bought", oblivionAndOathKeeper, rex);
		System.out.println(rexAct3);

		Activity gurvirAct = new Activity("Bought", bat, gurvir);
		System.out.println(gurvirAct);
		Activity gurvirAct2 = new Activity("Bought", claw, gurvir);
		System.out.println(gurvirAct2);
		Activity gurvirAct3 = new Activity("Bought", whisperOfTheWyrm, gurvir);
		System.out.println(gurvirAct3);

		Activity sudiptaAct = new Activity("Bought", unhappyFaceBall, rex);
		System.out.println(sudiptaAct);
		Activity sudiptaAct2 = new Activity("Bought", greenBall, rex);
		System.out.println(sudiptaAct2);
		Activity sudiptaAct3 = new Activity("Bought", earthBall, rex);
		System.out.println(sudiptaAct3);

		// creating a session factory and a session object for testing // using the
		// session factory also creates the tables in the DB
		SessionFactory sf = ConnectionService.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		// adding rex
		s.save(rex);
		s.save(gurvir);
		s.save(sudipta);
		s.save(tomi);

		// adding rex's credentials
		s.save(rexCred);
		s.save(gurvirCred);
		s.save(sudiptaCred);
		s.save(tomiCred);

		// adding whisper to the item marketplace
		s.save(oblivionAndOathKeeper);
		s.save(diamondArmor);
		s.save(diamondSword);
		s.save(paintBrush);
		s.save(redX);

		s.save(unhappyFaceBall);
		s.save(greenBall);
		s.save(redBall);
		s.save(earthBall);
		s.save(plasmaBall);

		s.save(whisperOfTheWyrm);
		s.save(claw);
		s.save(helmet);
		s.save(bat);
		s.save(gloves);

		// adding rex's player item
		s.save(rexPlayerItem);
		s.save(rexPlayerItem2);
		s.save(rexPlayerItem3);

		s.save(gurvirPlayerItem);
		s.save(gurvirPlayerItem2);
		s.save(gurvirPlayerItem3);

		s.save(sudiptaPlayerItem);
		s.save(sudiptaPlayerItem2);
		s.save(sudiptaPlayerItem3);

		/*
		 * s.save(tomiPlayerItem); s.save(tomiPlayerItem2); s.save(tomiPlayerItem3);
		 */

		// adding that rex bought whisper
		s.save(rexAct);
		s.save(rexAct2);
		s.save(rexAct3);

		s.save(gurvirAct);
		s.save(gurvirAct2);
		s.save(gurvirAct3);

		s.save(sudiptaAct);
		s.save(sudiptaAct2);
		s.save(sudiptaAct3);

		// committing and releasing resources
		tx.commit();
		s.close();

	}

}
