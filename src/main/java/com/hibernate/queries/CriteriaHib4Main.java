package com.hibernate.queries;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.model.onetomany.Student;
import com.hibernate.util.HibernateUtil;

public class CriteriaHib4Main {

	public static void main(String[] args) {
		//getAllStudentsWithCriteria();
		//getAllStudentsMatchingLNameWithCriteria();
		performProjectionQuery();
	}

	public static void getAllStudentsWithCriteria(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student>slist = criteria.list();
		System.out.println(slist.size());
		session.close();
		sf.close();
	}
	
	public static void getAllStudentsMatchingLNameWithCriteria(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("lName", "Marcel"));
		List<Student>slist = criteria.list();
		System.out.println(slist.size());
		session.close();
		sf.close();
	}
	
	public static void performProjectionQuery(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.setProjection( Projections.projectionList().add(Projections.groupProperty("lName"))
				.add( Projections.rowCount(), "studentCount" ));
		List list = criteria.list();
		System.out.println(list);
		session.close();
		sessionFactory.close();
		
		
	}
}
