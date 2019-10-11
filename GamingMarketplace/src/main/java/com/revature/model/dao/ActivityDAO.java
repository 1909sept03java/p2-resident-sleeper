package com.revature.model.dao;

import java.util.List;

import com.revature.bean.Activity;

public interface ActivityDAO {

	// this method returns a list of all player's
	public List<Activity> getAll();

	// this method returns a row in the player table
	public Activity getActivityById(int activityId);

	// this method adds a row into the player table
	public boolean addActivity(Activity activity);

	// this method updates a row in the player table
	public boolean updateActivity(Activity activity);

	// this method deletes a row in the player table
	public boolean deleteActivity(Activity activity);

}
