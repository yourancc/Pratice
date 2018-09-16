package cn.yourancc.jd.dao;

import java.util.ArrayList;

import cn.yourancc.jd.model.Cart;

public interface CartDao {
	public void add(Cart cart);
	public Cart[] findAll();
	public ArrayList<Cart> findById(Long id);
}
