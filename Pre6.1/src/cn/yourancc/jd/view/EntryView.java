package cn.yourancc.jd.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cn.yourancc.jd.core.RegisterCenter;
import cn.yourancc.jd.model.Cart;
import cn.yourancc.jd.model.Commodity;
import cn.yourancc.jd.service.CartService;
import cn.yourancc.jd.service.CommodityService;
import cn.yourancc.jd.service.impl.CartServiceImpl;
import cn.yourancc.jd.service.impl.CommodityServiceImpl;
import cn.yourancc.jd.utils.TSUtility;

public class EntryView {
	//获取商品服务
	CommodityService cms = RegisterCenter.cms;
	//获取购物车服务
	CartService cs = RegisterCenter.cs;

	public static void main(String[] args) {
		//创建入口对象
		EntryView ev = new EntryView();
		
		//进入主菜单
		ev.enterMainMenu();
		char selectNumber = TSUtility.readMenuSelection();
		//根据输入的数字判断要选择哪个菜单项1-6,6为退出
		while (selectNumber != 54) {
			switch (selectNumber) {
			case 49:// 1
				// 添加商品
				ev.addCommodity();
				
				//按回车键进入菜单
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 50:// 2
				// 查看所有商品
				ev.listAllCommodity();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 51:// 3
				// 根据id查找商品
				ev.findCommodityByCid();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 52:// 4
				// 添加商品到购物车
				ev.addCommodityToCart();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 53:// 5
				// 添加到商品列表
				ev.findMyAllCartItem();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			}
		}
	}

	//查找购物车内所有商品
	private void findMyAllCartItem() {
		// 打印表头信息
		pfl(fmt(8, "编号") + fmt(22, "商品名称") + fmt(10, "价格") + fmt(6, "数量") + fmt(6, "小计"));

		// 获取所有购物车数据
		Map<Commodity, Integer> map = cs.findAll();
		Iterator<Entry<Commodity, Integer>> it = map.entrySet().iterator();
		
		//获得统计总价
		Double totalPrice = 0.0;
		
		//循环遍历查找所有属于自己的购物车商品
		while (it.hasNext()) {
			Entry<Commodity, Integer> entry = it.next();
			Commodity cm = entry.getKey();
			
			//总价累计
			Double itemPrice = cm.getPrice() * entry.getValue();
			totalPrice += itemPrice;
			
			//输出购物车商品
			pf(fmt(8, cm.getCmId()) + fmt(22, cm.getName()) + fmt(10, cm.getCount()) + fmt(6,entry.getValue()) + fmt(6, itemPrice));
			pfl("");// 换行
			
		}
		pfl("总价: " + totalPrice);
	}

	//添加商品到购物车中
	private void addCommodityToCart() {
		pfl("请输入要添加的商品编号");
		Long cid = TSUtility.readLong();
		Commodity cm = cms.findById(cid);
		Cart cart = new Cart();
		if (cm == null) {
			pfl("该商品的编号不存在");
			return;
		}
		pfl("请输入要购买的数量");
		int count = TSUtility.readInt();

		// 封装属性
		cart.setCartId(getCurrentUserCartID());
		cart.setCmId(cm.getCmId());
		cart.setCount(count);

		cs.add(cart);
		pf("添加成功,");
	}

	//通过id查找商品
	private void findCommodityByCid() {
		pfl("请输入要查询的商品编号");
		Long cid = TSUtility.readLong();
		Commodity cm = cms.findById(cid);
		if (cm == null) {
			pfl("该商品的编号不存在");
			return;
		}
		
		//打印商品信息
		pfl(fmt(8, "编号") + fmt(22, "商品名称") + fmt(10, "价格") + fmt(10, "颜色") + fmt(8, "尺寸") + fmt(8, "库存"));
		pfl(fmt(8, cm.getCmId()) + fmt(22, cm.getName()) +fmt(10,cm.getPrice())+ fmt(10, cm.getColor()) + fmt(8, cm.getSize())
				+ fmt(8, cm.getCount()));

	}

	// 主界面显示及控制方法
	public void enterMainMenu() {
		pfl("**********欢   迎   进   入   京   东   商   城************");
		pfl("                    1.添加商品                              ");
		pfl("                    2.查看所有商品                            ");
		pfl("                    3.查看指定编号商品                         ");
		pfl("                    4.添加到购物车                            ");
		pfl("                    5.显示购物车                             ");
		pfl("                    6.退出                                 ");
		pfl("*********************************************************");
		pfl("请选择菜单");
	}

	//列出所有商品
	private void listAllCommodity() {
		// 打印表头信息
		pfl(fmt(8, "编号") + fmt(22, "商品名称") + fmt(10, "价格") + fmt(10, "颜色") + fmt(8, "尺寸") + fmt(8, "库存"));

		// 获取所有员工数据表
		Commodity[] commodities = cms.findAll();

		// 通过遍历打印出所有员工信息
		for (int i = 0; i < commodities.length; i++) {
			Commodity e = commodities[i];
			String name = e.getName();

			//打印商品
			pf(fmt(8, e.getCmId()) + fmt(22, e.getName())+ fmt(10,e.getPrice())+ fmt(10, e.getColor()) + fmt(8, e.getSize())
					+ fmt(8, e.getCount()));
			pfl("");// 换行
		}
	}

	
	//添加商品
	private void addCommodity() {
		Commodity cm = new Commodity();
		pfl("请输入商品编号");
		cm.setCmId(TSUtility.readLong());
		pfl("请输入商品名称");
		cm.setName(TSUtility.readLine());
		pfl("请输入商品价格");
		cm.setPrice(TSUtility.readDouble());
		pfl("请输入商品颜色");
		cm.setColor(TSUtility.readLine());
		pfl("请输入商品尺寸");
		cm.setSize(TSUtility.readInt());
		pfl("请输入商品库存");
		cm.setCount(TSUtility.readInt());
		cms.add(cm);
		pf("添加成功.");
	}

	/*
	 * System.out.print的简写，打印信息不换行
	 * 
	 * @param 要打印的信息
	 */
	private <T> void pf(T x) {
		System.out.print(x);
	}

	/*
	 * System.out.println的简写，打印信息换行
	 * 
	 * @param 要打印的信息
	 */
	private <T> void pfl(T x) {
		System.out.println(x);
	}

	/*
	 * * 左对齐格式化输出定长字符串
	 * 
	 * @param length 字符串长度
	 * 
	 * @param message 字符串信息
	 * 
	 * @return 定长字符串
	 */
	@SuppressWarnings("unused")
	private <T> String fmt(int length, T message) {
		StringBuffer sb = new StringBuffer(message.toString());
		int count=0;
		for(int i=0; i<sb.length(); i++) {
			char c = sb.charAt(i);
			if(c>255)
				count++;
			count++;
		}
		if(count>length)
			return sb.toString();
		//System.out.println(count);
		for (; count < length; count++) {
			
			sb.append(" ");
		}
		return sb.toString();
	}

	/*
	 * 左对齐格式化输出定长字符串
	 * 
	 * @param length 字符串长度
	 * 
	 * @param message 字符串信息
	 * 
	 * @return 定长字符串
	 */
	private <T> String fmt2(int length, T message) {

		return String.format("%-" + length + "s", message);
	}

	public static Long getCurrentUserCartID() {
		return 1l;
	}
}
