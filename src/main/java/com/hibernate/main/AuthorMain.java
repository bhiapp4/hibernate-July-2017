package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.composite.Author;
import com.hibernate.composite.AuthorId;
import com.hibernate.util.HibernateUtil;

public class AuthorMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		AuthorId aId = new AuthorId();
		aId.setCity("Argyle");
		aId.setName("Peter");
		Author author = new Author();
		author.setAuthorId(aId);
		author.setBookName("Python Programming");
		author.setIsbn("AB1245");
		session.save(author);
		session.getTransaction().commit();
		session.close();
		sf.close();


	}

}
