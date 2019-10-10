package com.revature.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.bean.Activity;
import com.revature.service.ConnectionService;

public class ActivityDAOImpl implements ActivityDAO {

	private SessionFactory sf = ConnectionService.getSessionFactory();

	@Override
	public List<Activity> getAll() {
		List<Activity> activityList = new ArrayList<>();
		try (Session s = sf.openSession()) {
			activityList = s.createQuery("from Activity").getResultList();
		}
		return activityList;
	}

	@Override
	public Activity getActivityById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addActivity(Activity activity) {
		boolean isAdded = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.save(activity);
			tx.commit();
			isAdded = true;
		}
		return isAdded;	
	}

	@Override
	public boolean updateActivity(Activity activity) {
		boolean isUpdated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Update Activity Set TYPE =: type, ITEM_ID =: itemId, PLAYER_ID =: playerId Where ACTIVITY_ID =: activityId";
			Query query = s.createQuery(hql);
			query.setParameter("type", activity.getType());
			query.setParameter("itemId", activity.getItem().getItemId());
			query.setParameter("activityId", activity.getActivityId());
			query.executeUpdate();
			tx.commit();
			isUpdated = true;
		}
		return isUpdated;				
	}

	@Override
	public boolean deleteActivity(Activity activity) {
		boolean isDeleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Delete from Activity Where ACTIVITY_ID =: activityId";
			Query query = s.createQuery(hql);
			query.setParameter("activityId", activity.getActivityId());
			query.executeUpdate();
			tx.commit();
			isDeleted = true;
		}
		return isDeleted;		
	}

}
