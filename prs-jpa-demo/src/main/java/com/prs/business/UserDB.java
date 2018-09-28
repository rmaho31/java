package com.prs.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.prs.db.DBUtil;


public class UserDB {
	
	public UserDB() {
	}
		
	public static List<User> list() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		List<User> users = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT u FROM User u");
			users = q.getResultList();
		} finally {
			em.close();
		}
		
		return users;
	}

	public boolean add(User u) {
       return true;
	}

	public boolean remove(User u) {
		return true;
	}
}
