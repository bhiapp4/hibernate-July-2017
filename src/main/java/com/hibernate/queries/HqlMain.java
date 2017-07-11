package com.hibernate.queries;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.onetomany.Course;
import com.hibernate.model.onetomany.Student;
import com.hibernate.util.HibernateUtil;

public class HqlMain {

	public static void main(String[] args) {
		//getAllStudents();
		//queryStudentWithWhere();
		//queryStudentWithWhereWithNamedParam();
		//findStudentsRegistedForCourseId1();
		//findCoursesRegistedByStudentWithId1();
		 //findCourseCountRegistedByStudentWithId1();
		 //findCourseNameToStudentCount();
		 findStudentToCourseCount();
	}
	
	public static void getAllStudents(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("from Student");
		List<Student> studentList = query.getResultList();
		System.out.println(studentList.size());
		session.close();
		sf.close();
	}
	
	public static void queryStudentWithWhere(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("from Student where fName=?");
		query.setParameter(0, "Michael");
		Student student = (Student) query.getSingleResult();
		System.out.println(student.getlName());
		session.close();
		sf.close();
	}
	
	public static void queryStudentWithWhereWithNamedParam(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("from Student where fName=:fname");
		query.setParameter("fname", "Michael");
		Student student = (Student) query.getSingleResult();
		System.out.println(student.getlName());
		session.close();
		sf.close();
	}
	
	public static void findStudentsRegistedForCourseId1(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("from Student s join s.courses c where c.courseId=1 ");
		List<Student> studentList = query.getResultList();
		System.out.println(studentList.size());
		session.close();
		sf.close();
	}
	
	public static void findCoursesRegistedByStudentWithId1(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("from Course c join c.students s where s.studentId=1 ");
		List<Course> courseList = query.getResultList();
		System.out.println(courseList.size());
		session.close();
		sf.close();
	}
	
	public static void findCourseCountRegistedByStudentWithId1(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("select count(*) from Course c join c.students s where s.studentId=1 ");
		Long count = (Long)query.getSingleResult();
		System.out.println(count);
		session.close();
		sf.close();
	}
	
	public static void findCourseNameToStudentCount(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("select c.name,count(*) from Course c join c.students s group by c.courseId ");
		List<Object> cList  = query.getResultList();
		System.out.println(cList.size());
		session.close();
		sf.close();
	}
	
	public static void findStudentToCourseCount(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =session.createQuery("select s.fName,count(*) from Student s left join s.courses c group by s.studentId having count(*) > 1");
		List<Object> cList  = query.getResultList();
		System.out.println(cList.size());
		session.close();
		sf.close();
	}
	
	

}
