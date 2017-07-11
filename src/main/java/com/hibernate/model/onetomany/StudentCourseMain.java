package com.hibernate.model.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class StudentCourseMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
//		Student student = new Student();
//		student.setfName("Michael");
//		student.setlName("Marcel");
//		Student student1 = new Student();
//		student1.setfName("Alby");
//		student1.setlName("Marcel");
//		
		Student student2 = new Student();
		student2.setfName("Davey");
		student2.setlName("Marcel");

//		Course course = new Course();
//		course.setName("Java Programming");
//		course.getStudents().add(student);
//		course.getStudents().add(student1);
//		
//		Course course1 = new Course();
//		course1.setName("Python Programming");
//		course1.getStudents().add(student);
//		
//		
//		
//		session.save(student);
//		session.save(student1);
		session.save(student2);
		
//		session.save(course);
//		session.save(course1);

//		Student student = session.load(Student.class, 2L);
//		session.delete(student);
//		Course course = session.load(Course.class, 1L);
//		session.delete(course);
		
//		Student student = session.load(Student.class, 2L);
//		Course course = session.load(Course.class, 1L);
//		course.getStudents().add(student);
//		session.update(course);

		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
