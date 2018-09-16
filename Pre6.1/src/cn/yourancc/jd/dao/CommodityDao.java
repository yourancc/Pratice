package cn.yourancc.jd.dao;

import cn.yourancc.jd.model.Commodity;

public interface CommodityDao {

	public void add(Commodity cm);
	public Commodity[] findAll();
	public Commodity findById(Long l);
}
