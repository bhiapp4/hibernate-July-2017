package com.hibernate.queries;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernate.model.onetomany.Course;
import com.hibernate.model.onetomany.Student;
import com.hibernate.util.HibernateUtil;

public class CriteriaMain {

	public static void main(String[] args) {
		//getAllStudentsWithCriteria();
		findStudentsByLastName();
	}
	
	public static void getAllStudentsWithCriteria(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		CriteriaQuery<Student> criteria = session.getCriteriaBuilder().createQuery(Student.class);
		Root<Student> root = criteria.from( Student.class );//create root
		criteria.select(root);//select the root
		Query<Student>squery = session.createQuery(criteria);
		List<Student>slist = squery.getResultList();
		System.out.println(slist.size());
		session.close();
		sf.close();
	}
	
	public static void findStudentsByLastName(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();//create criteria builder
		CriteriaQuery<Student> criteria = criteriaBuilder.createQuery(Student.class);//create criteria for the class that we are querying
		Root<Student> root = criteria.from( Student.class );//create root
		criteria.select(root);//select the root
		ParameterExpression<String> lastNameParameter = criteriaBuilder.parameter( String.class );//define input parameter
		criteria.where( criteriaBuilder.equal( root.get("lName" ), lastNameParameter ) );//add where condition

		TypedQuery<Student> query = session.createQuery( criteria );//create a query object
		query.setParameter( lastNameParameter, "Marcel" );//set the parameter with the value
		List<Student> students = query.getResultList();//get results
		System.out.println(students.size());
		session.close();
		sessionFactory.close();		
	}
	

}
