package cn.yourancc.jd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.yourancc.jd.core.RegisterCenter;
import cn.yourancc.jd.dao.CartDao;
import cn.yourancc.jd.dao.impl.CartDaoImpl;
import cn.yourancc.jd.model.Cart;
import cn.yourancc.jd.model.Commodity;
import cn.yourancc.jd.service.CartService;
import cn.yourancc.jd.service.CommodityService;
import cn.yourancc.jd.view.EntryView;

public class CartServiceImpl implements CartService {

	CartDao cd = RegisterCenter.cd;
	CommodityService cms = new CommodityServiceImpl();
	@Override
	public void add(Cart cart) {
		cd.add(cart);
	}

	@Override
	public Map<Commodity,Integer> findAll() {
		ArrayList<Cart> al = cd.findById(EntryView.getCurrentUserCartID());
		Map map = new HashMap<>(); 
		for(Cart cart : al) {

			//如果购物车属于自己，则添加到map中
			Long cid = cart.getCmId();
			Commodity com = cms.findById(cid);
			map.put(com, cart.getCount());
		}
		
		return map;

	}

}
