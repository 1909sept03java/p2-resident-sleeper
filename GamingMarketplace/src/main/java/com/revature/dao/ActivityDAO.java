package com.revature.dao;

import java.util.List;

import com.revature.model.Activity;

public interface ActivityDAO {

	// this method returns a list of all the rows in the Activity Table
	public List<Activity> getAll();

	// this method returns a specific row in the Activity Table by activityId
	public Activity getActivityById(int activityId);

	// this method adds a row into the Activity Table
	public boolean addActivity(Activity activity);

	// this method updates a row in the Activity Table
	public boolean updateActivity(Activity activity);

	// this method deletes a row in the Activity Table
	public boolean deleteActivity(Activity activity);

}
