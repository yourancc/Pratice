package cn.yourancc.jd.service.impl;

import java.io.IOException;

import cn.yourancc.jd.core.RegisterCenter;
import cn.yourancc.jd.dao.CartDao;
import cn.yourancc.jd.dao.CommodityDao;
import cn.yourancc.jd.dao.impl.CommodityDaoImpl;
import cn.yourancc.jd.model.Commodity;
import cn.yourancc.jd.service.CommodityService;

public class CommodityServiceImpl implements CommodityService {

	CommodityDao cmd = RegisterCenter.cmd; 
	
	@Override
	public void add(Commodity cm) {
		cmd.add(cm);
	}

	@Override
	public Commodity[] findAll() {
		
		return cmd.findAll();
	}

	@Override
	public Commodity findById(Long cid) {
		// TODO Auto-generated method stub
		return cmd.findById(cid);
	}

	@Override
	public void saveAll() {
		try {
			cmd.saveAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void readAll() {
		try {
			cmd.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
