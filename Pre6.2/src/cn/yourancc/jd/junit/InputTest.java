package cn.yourancc.jd.junit;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import cn.yourancc.jd.core.RegisterCenter;
import cn.yourancc.jd.dao.CommodityDao;
import cn.yourancc.jd.dao.impl.CartDaoImpl;
import cn.yourancc.jd.dao.impl.CommodityDaoImpl;
import cn.yourancc.jd.model.Cart;
import cn.yourancc.jd.model.Commodity;
import cn.yourancc.jd.utils.TSUtility;

public class InputTest {

	CommodityDaoImpl cmd = null;
	CartDaoImpl cd = null;
	@Before
	public void before() {
		cmd = (CommodityDaoImpl) RegisterCenter.cmd;
		//(Long cmId, String name, Double price, String color, Integer size, Integer count)
		cmd.add(new Commodity(1005l,"小米",999.5,"黑色",9,100));
		cmd.add(new Commodity(1003l,"三星",2499.5,"黑色",7,100));
		cmd.add(new Commodity(1006l,"苹果",959.5,"玫瑰金",11,100));
		cmd.add(new Commodity(1007l,"小米",4729.5,"黑色",6,100));
		cd = (CartDaoImpl) RegisterCenter.cd;
		cd.add(new Cart(1l,1003l,40));
		cd.add(new Cart(1l,1005l,40));
		cd.add(new Cart(1l,1007l,40));
		
	}
	
	@Test
	public void test() throws FileNotFoundException, IOException, ClassNotFoundException {
		cmd.saveAll();
		cmd.map.clear();
		cmd.readAll();
		;
		System.out.println(cmd.map.toString());
		
		cd.saveAll();
		cd.list.clear();
		cd.readAll();
		System.out.println(cd.list.toString());
	}
	

}
