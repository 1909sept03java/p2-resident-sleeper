package com.revature.model;

public class Activity {

	private int activityId; // primary key for activity table
	private int itemId; // foreign key to marketplace item table
	private String activityType; // bought or sold
	private int userId; // foreign key to user table
	
}
