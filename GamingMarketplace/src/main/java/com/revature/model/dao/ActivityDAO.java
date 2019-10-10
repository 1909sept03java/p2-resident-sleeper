package com.revature.model.dao;

import java.util.List;

import com.revature.model.bean.Activity;

public interface ActivityDAO {

	// this method returns a list of all player's
	public List<Activity> getAll();

	// this method returns a row in the player table
	public Activity getActivityById();

	// this method adds a row into the player table
	public void addActivity(Activity activity);

	// this method updates a row in the player table
	public void updateActivity(Activity activity);

	// this method deletes a row in the player table
	public void deleteActivity(Activity activity);

}
