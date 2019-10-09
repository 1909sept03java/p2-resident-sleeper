package com.revature.model;

public class User {

	private int userId; // primary key for User table
	private String username; // used to login- username field
	private String password; // used to login- password field
	private String email;
	private String firstname;
	private String lastname;
	private String avatarFilename; // the filename of the users avatar image
	private int coins; // amount of coins saved up from playing games
	private int minutes; // total time spent playing games in minutes

}
