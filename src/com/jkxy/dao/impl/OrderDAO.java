package com.jkxy.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.jkxy.dao.IOrderDAO;
import com.jkxy.model.Orders;

public class OrderDAO implements IOrderDAO {

	private SessionFactory sessionFacory;

		public SessionFactory getSessionFacory() {
		return sessionFacory;
	}

	public void setSessionFacory(SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

		public Orders saveOrder(Orders order) {
			// TODO Auto-generated method stub
			Session session=sessionFacory.openSession();
			Transaction ts=session.beginTransaction();
			session.save(order);
			ts.commit();
			session.close();
			return order;
		}
		
	}
