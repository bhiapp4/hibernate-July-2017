package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.inheritance.ContractingEmployee;
import com.hibernate.inheritance.FullTimeEmployee;
import com.hibernate.util.HibernateUtil;

public class InheritanceMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		
		FullTimeEmployee fe = new FullTimeEmployee();
		fe.setfName("Andy");
		fe.setlName("Marcel");
		fe.setAge(35);
		fe.setSalary(120000L);
		fe.setPaidVacationDays(14);
		
		
		ContractingEmployee ce = new ContractingEmployee();
		ce.setfName("Mike");
		ce.setlName("Marcel");
		ce.setAge(35);
		ce.setHourlyRate(75);
		ce.setNoOfHours(60);
		session.save(fe);
		session.save(ce);
		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
