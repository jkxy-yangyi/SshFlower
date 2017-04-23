package com.jkxy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.IUserDAO;
import com.jkxy.model.Guashi;
import com.jkxy.model.User;

public class UserDAO implements IUserDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(user);
		ts.commit();
		session.close();
		return true;
	}

	public User checkUser(User user) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username='"
				+ user.getUsername() + "' and password='" + user.getPassword()
				+ "' and role='" + user.getRole() + "'");
		User user1 = new User();
		List list = query.list();
		session.clear();
		session.close();
		if (list.size() != 0) {
			user1 = (User) list.get(0);
			return user1;
		}
		return null;
	}

	public boolean guashiUser(int id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from User where userid=" + id);
		User user1 = (User) (query.list().get(0));
		Guashi gUser = new Guashi();
		gUser.setUser(user1);
		user1.setGuashi(gUser);
		session.saveOrUpdate(gUser);
		ts.commit();
		session.close();
		return true;

	}

	@Override
	public boolean jieguaUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from User where userid=" + id);
		List list = query.list();
		User user1 = (User) list.get(0);
		if(user1.getGuashi()==null){
			return false;
		}else {
			session.delete(user1.getGuashi());
			ts.commit();
			session.close();
			return true;
		}
		
	}
	public List getGuashi() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Guashi");
		       List list=query.list();
		       
		       ts.commit();
		       return list;
	}
}
