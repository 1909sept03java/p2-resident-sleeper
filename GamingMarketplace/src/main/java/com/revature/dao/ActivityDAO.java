package com.revature.dao;

import java.util.List;

<<<<<<< HEAD:GamingMarketplace/src/main/java/com/revature/dao/ActivityDAO.java
import com.revature.model.Activity;
=======
import com.revature.bean.Activity;
>>>>>>> service_classes:GamingMarketplace/src/main/java/com/revature/model/dao/ActivityDAO.java

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
