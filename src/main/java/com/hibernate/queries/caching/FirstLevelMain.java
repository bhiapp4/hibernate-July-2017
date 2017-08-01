package com.hibernate.queries.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.User;
import com.hibernate.util.HibernateUtil;

public class FirstLevelMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		User user1 = s.get(User.class, 1L);
		System.out.println(user1.getUserName());
		
		Session s1 = sf.openSession();
		User user2 = s1.get(User.class, 1L);
		System.out.println(user2.getUserName());
		s.close();
		s1.close();
		sf.close();
	}

}
