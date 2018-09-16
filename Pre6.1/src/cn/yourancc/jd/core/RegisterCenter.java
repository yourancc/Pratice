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
 * Ϊ���ܱ�֤�ڶ����ص��õĹ�ϵ�У������Ψһ�ԣ����еĶ�����ע�����Ĵ���������ȡ
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
		cm.setColor("��ɫ");
		cm.setCount(50);
		cm.setName("Galaxy Note8");
		cm.setPrice(1799.0);
		cm.setSize(9);
		cmd.add(cm);
	}
}
