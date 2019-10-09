package com.revature.model;

public class Activity {

	private int activityId; // primary key for activity table
	private int itemId; // foreign key to marketplace item table
	private String itemName; // the name of the item
	private String activityType; // bought, sold, or traded
	private int userId; // foreign key to user table
	
	private int value; // value of the item
	
}
