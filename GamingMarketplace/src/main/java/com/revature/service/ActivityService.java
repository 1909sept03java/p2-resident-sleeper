package com.revature.service;

import java.util.List;

import com.revature.dao.ActivityDAO;
import com.revature.dao.ActivityDAOImpl;
import com.revature.model.Activity;

public class ActivityService {
	ActivityDAO activityDAO = new ActivityDAOImpl();

	// this method returns a list of all player's
	public List<Activity> getAll(){
		return activityDAO.getAll();
	}

	// this method returns a row in the player table
	public Activity getActivityById(int activityId) {
		return activityDAO.getActivityById(activityId);
	}


	// this method adds a row into the player table
	public boolean addActivity(Activity activity) {
		return activityDAO.addActivity(activity);
	}

	// this method updates a row in the player table
	public boolean updateActivity(Activity activity) {
		return activityDAO.updateActivity(activity);
	}

	// this method deletes a row in the player table
	public boolean deleteActivity(Activity activity) {
		return activityDAO.deleteActivity(activity);
	}
}
