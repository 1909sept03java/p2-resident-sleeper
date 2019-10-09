package com.revature.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "activitySequence")
	@SequenceGenerator(allocationSize = 1, name = "activitySequence", sequenceName = "SQ_ACTIVITY_PK")
	@Column(name = "ACTIVITY_ID")
	private int activityId; // primary key for the activity table
	@Column(name = "TYPE")
	private String type; // bought or sold
	
	private int itemId; // foreign key to item table
	private int playerId; // foreign key to player table
	
}
