package cn.yourancc.jd.service;

import cn.yourancc.jd.model.Commodity;

public interface CommodityService {

	public void add(Commodity cm);
	public Commodity[] findAll();
	public Commodity findById(Long cid);
}
