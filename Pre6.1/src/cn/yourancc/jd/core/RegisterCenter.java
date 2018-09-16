package cn.yourancc.jd.core;

import cn.yourancc.jd.dao.CartDao;
import cn.yourancc.jd.dao.CommodityDao;
import cn.yourancc.jd.dao.impl.CartDaoImpl;
import cn.yourancc.jd.dao.impl.CommodityDaoImpl;
import cn.yourancc.jd.model.Commodity;
import cn.yourancc.jd.service.CartService;
import cn.yourancc.jd.service.CommodityService;
import cn.yourancc.jd.service.impl.CartServiceImpl;
import cn.yourancc.jd.service.impl.CommodityServiceImpl;

/**
 * 为了能保证在多层相关调用的关系中，对象的唯一性，所有的对象都在注册中心创建，并获取
 * @author Administrator
 *
 */
public class RegisterCenter {
	
	public static CartDao cd = new CartDaoImpl();
	public static  CommodityDao cmd = new CommodityDaoImpl();
	public static CartService cs = new CartServiceImpl();
	public static  CommodityService cms = new CommodityServiceImpl();
	static {
		Commodity cm = new Commodity();
		cm.setCmId(1001l);
		cm.setColor("红色");
		cm.setCount(50);
		cm.setName("Galaxy Note8");
		cm.setPrice(1799.0);
		cm.setSize(9);
		cmd.add(cm);
	}
}
