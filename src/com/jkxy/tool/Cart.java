package com.jkxy.tool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jkxy.model.Flower;
import com.jkxy.model.Orderitem;

public class Cart {
	private Map items;

	public Map getItems() {
		return items;
	}

	public void setItems(Map items) {
		this.items = items;
	}

	public Cart() {
		// TODO Auto-generated constructor stub
		if (items == null)
			items = new HashMap<Integer, Orderitem>();
	}

	/**
	 * 添加鲜花数量
	 * @param flowerId
	 * @param orderitem
	 */
	public void addFlower(int flowerId, Orderitem orderitem) {
		//判断购物车是否有相同的花品，有则将数量相加
		if (items.containsKey(flowerId)) {
			//获取购物车中已有订单项
			Orderitem _orderitem = (Orderitem) items.get(flowerId);
			orderitem.setQuantity(_orderitem.getQuantity()
					+ orderitem.getQuantity());
			items.put(flowerId, orderitem);
		} else
			items.put(flowerId, orderitem);
	}

	/**
	 * 更该鲜花数量
	 * @param flowerId
	 * @param quantity
	 */
	public void updateCart(int flowerId, int quantity) {
		Orderitem orderitem = (Orderitem) items.get(flowerId);
		orderitem.setQuantity(quantity);
		items.put(flowerId, orderitem);
	}

	/**
	 * 计算总价格
	 * @return
	 */
	public int getTotalPrice() {
		int totalPrice = 0;
		for (Iterator it = items.values().iterator(); it.hasNext();) {
			Orderitem orderitem = (Orderitem) it.next();
			Flower flower = orderitem.getFlower();
			int quantity = orderitem.getQuantity();
			totalPrice += flower.getPrice() * quantity;
		}
		return totalPrice;
	}
}
