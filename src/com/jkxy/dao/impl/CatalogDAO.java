package com.jkxy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.ICatalogDAO;
import com.jkxy.model.Catalog;

public class CatalogDAO implements ICatalogDAO  {
private SessionFactory sessionFactory;

public SessionFactory getSessionfactory() {
	return sessionFactory;
}

public void setSessionfactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

	@Override
	public List<Catalog> getAllCatalogs() {
		
		Session session=sessionFactory.openSession();	//获取会话
		Transaction ts=session.beginTransaction();		//获取事务管理
		//Query query=session.createQuery("from Catalog");
		Query query=session.createQuery("from Catalog");
		List<Catalog> catalogs=query.list();
		ts.commit();
		session.close();
		return catalogs;
		
		
	}


	

}
