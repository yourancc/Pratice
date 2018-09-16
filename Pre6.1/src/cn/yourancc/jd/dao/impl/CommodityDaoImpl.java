package cn.yourancc.jd.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.yourancc.jd.dao.CommodityDao;
import cn.yourancc.jd.model.Commodity;

public class CommodityDaoImpl implements CommodityDao{

	Map<String,Commodity> map = new HashMap<>();
	
	@Override
	public void add(Commodity cm) {
		map.put(cm.getCmId().toString(), cm);
	}

	@Override
	public Commodity[] findAll() {
		int len = map.size();
		Commodity[] commodities = new Commodity[len];
		int i=0;
		Iterator<Commodity> it = map.values().iterator();
		while(it.hasNext()) {
			commodities[i++] =it.next();
		}
		return commodities;
	}

	@Override
	public Commodity findById(Long l) {
		Commodity cm = map.get(l.toString());
		return cm;
	}

	

}
