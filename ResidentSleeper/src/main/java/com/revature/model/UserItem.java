package com.revature.model;

public class UserItem {

	private int userItemId; // primary key for UserItem table
	private int userId; // foreign key to user table, one user many user item
	private String userItemname; // item name
	private int value; // value of the item
	private String userItemFilename; // name of the image file
	private boolean forSale; // if true then it is for sale

}
