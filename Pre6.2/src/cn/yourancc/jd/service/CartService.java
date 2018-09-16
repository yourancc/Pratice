package cn.yourancc.jd.service;

import java.util.Map;

import cn.yourancc.jd.model.Cart;
import cn.yourancc.jd.model.Commodity;

public interface CartService {

	public void add(Cart cart);
	public Map<Commodity,Integer> findAll();
	public void saveAll();
	public void readAll();
}
