package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.ActivityDAO;
import com.revature.model.Activity;

public class ActivityService {

	private ActivityDAO activityDAO;

	@Autowired
	public ActivityService(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}
	
	// this method returns a list of all player's
	public List<Activity> getAll() {
		return this.activityDAO.getAll();
	}

	// this method returns a row in the player table
	public Activity getActivityById(int activityId) {
		return this.activityDAO.getActivityById(activityId);
	}

	// this method adds a row into the player table
	public boolean addActivity(Activity activity) {
		return this.activityDAO.addActivity(activity);
	}

	// this method updates a row in the player table
	public boolean updateActivity(Activity activity) {
		return this.activityDAO.updateActivity(activity);
	}

	// this method deletes a row in the player table
	public boolean deleteActivity(Activity activity) {
		return this.activityDAO.deleteActivity(activity);
	}

}