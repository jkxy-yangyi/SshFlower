package com.jkxy.service.impl;


import com.jkxy.dao.IOrderDAO;
import com.jkxy.model.Orders;
import com.jkxy.service.IOrderService;

public class OrderService implements IOrderService{
private IOrderDAO orderDAO;

	
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}


	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}


	@Override
	public Orders saveOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDAO.saveOrder(order);
	}

}
