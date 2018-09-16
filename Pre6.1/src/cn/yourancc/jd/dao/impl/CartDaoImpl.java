package cn.yourancc.jd.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.yourancc.jd.dao.CartDao;
import cn.yourancc.jd.model.Cart;
import cn.yourancc.jd.model.Commodity;
import cn.yourancc.jd.view.EntryView;

public class CartDaoImpl implements CartDao{
	List<Cart> list = new ArrayList<>();
	@Override
	public void add(Cart cart) {
		for(Cart c : list) {
			if(c.getCmId() == cart.getCmId()) {
				//如果购物车中已有该商品则讲数量合并并返回
				c.setCount(c.getCount() +cart.getCount());
				return;
			}
		}
		list.add(cart);
	}

	@Override
	public Cart[] findAll() {
//		int len = list.size();
//		Cart[] carts = new Cart[len];
//		int i=0;
//		Iterator<Cart> it = list.iterator();
//		while(it.hasNext()) {
//			carts[i++] =it.next();
//		}
//		return carts;
		return (Cart[]) list.toArray();
	}

	@Override
	public ArrayList<Cart> findById(Long id) {
		ArrayList<Cart> al = new ArrayList<>();
		Iterator<Cart> it = list.iterator();
		while(it.hasNext()) {
			Cart cart = it.next();
			//如果购物车属于自己 则添加到arraylist中
			if(cart.getCartId() == EntryView.getCurrentUserCartID()) {
				al.add(cart);
			}
		}

		return al;
	}

}
