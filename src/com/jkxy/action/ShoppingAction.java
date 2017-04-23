package com.jkxy.action;

import java.util.Map;
import com.jkxy.model.Flower;
import com.jkxy.model.Orderitem;
import com.jkxy.model.User;
import com.jkxy.service.IFlowerService;
import com.jkxy.service.impl.FlowerService;
import com.jkxy.tool.Cart;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingAction extends ActionSupport {
	private int id;
	private int quantity;
	private IFlowerService flowerService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public IFlowerService getFlowerService() {
		return flowerService;
	}

	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}

	public String addToCart() throws Exception {
		Flower flower = flowerService.getFlowerById(id);
		//创建订单项
		Orderitem orderitem = new Orderitem();
		orderitem.setFlower(flower);
		orderitem.setQuantity(quantity);
		Map session = (Map) ActionContext.getContext().getSession();

		//创建购物车（有则不创建，没有则创建）
		Cart cart = (Cart) session.get("cart");
		if (cart == null)
			cart = new Cart();
		cart.addFlower(id, orderitem);
		session.put("cart", cart);
		// System.out.println(cart.getItems().size());
		User user= (User) session.get("user");
		if(user==null){
			session.clear();
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 更新购物车
	 * @return
	 * @throws Exception
	 */
	public String updateCart() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();

		Cart cart = (Cart) session.get("cart");
		cart.updateCart(id, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}

	public String checkout() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();

		Cart cart = (Cart) session.get("cart");
		cart.updateCart(id, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
}
