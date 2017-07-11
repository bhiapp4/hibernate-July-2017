package com.hibernate.queries;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class NativeSqlMain {
	
	public static final String SQL="select student0_.fName as col_0_0_, count(*) as col_1_0_ from Student student0_ inner join Student_Course courses1_ on student0_.studentId=courses1_.StudentId inner join Course course2_ on courses1_.CourseId=course2_.courseId group by student0_.studentId having count(*)>1";

	public static void main(String[] args) {
		findStudentToCourseCount();
	}
	
	public static void findStudentToCourseCount(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createNativeQuery(SQL);
		List<Object> cList  = query.getResultList();
		System.out.println(cList.size());
		session.close();
		sf.close();
	}

}
