package com.hibernate.queries;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class NamedQueryMain {
	
	public static void main(String[] args) {
		//findStudentToCourseCount();
		findStudentToCourseCountNatively();
	}

	public static void findStudentToCourseCount() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session
				.createNamedQuery("findAllStudentsWithCourseCount");
		List<Object> cList = query.getResultList();
		System.out.println(cList.size());
		session.close();
		sf.close();
	}
	
	public static void findStudentToCourseCountNatively() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query = session.createNamedQuery("findAllStudentsWithCourseCountNatively");
		List<Object> cList = query.getResultList();
		System.out.println(cList.size());
		session.close();
		sf.close();
	}
}
