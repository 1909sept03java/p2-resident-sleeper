package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Item;

@Repository(value = "ItemDAO")
public class ItemDAOImpl implements ItemDAO {

	private SessionFactory sf;

	@Autowired // constructor injection
	public ItemDAOImpl(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Item> getAll() {
		List<Item> itemList = new ArrayList<>();
		try (Session s = sf.openSession()) {
			itemList = s.createQuery("from Item").getResultList();
		}
		return itemList;
	}

	@Override
	public Item getItemById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(Item item) {
		boolean isAdded = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.save(item);
			tx.commit();
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public boolean updateItem(Item item) {
		boolean isUpdated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Update Player Set NAME =: name, VALUE =: value, ITEM_FILENAME =: itemFilename Where ITEM_ID =: itemId";
			Query query = s.createQuery(hql);
			query.setParameter("name", item.getName());
			query.setParameter("value", item.getValue());
			query.setParameter("itemFilename", item.getItemFilename());
			query.setParameter("itemId", item.getItemId());
			query.executeUpdate();
			tx.commit();
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteItem(Item item) {
		boolean isDeleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			String hql = "Delete from Item Where ITEM_ID =: itemId";
			Query query = s.createQuery(hql);
			query.setParameter("itemId", item.getItemId());
			query.executeUpdate();
			tx.commit();
			isDeleted = true;
		}
		return isDeleted;
	}

}
