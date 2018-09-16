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
	//��ȡ��Ʒ����
	CommodityService cms = RegisterCenter.cms;
	//��ȡ���ﳵ����
	CartService cs = RegisterCenter.cs;

	public static void main(String[] args) {
		//������ڶ���
		EntryView ev = new EntryView();
		
		//�������˵�
		ev.enterMainMenu();
		char selectNumber = TSUtility.readMenuSelection();
		//��������������ж�Ҫѡ���ĸ��˵���1-6,6Ϊ�˳�
		while (selectNumber != 54) {
			switch (selectNumber) {
			case 49:// 1
				// �����Ʒ
				ev.addCommodity();
				
				//���س�������˵�
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 50:// 2
				// �鿴������Ʒ
				ev.listAllCommodity();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 51:// 3
				// ����id������Ʒ
				ev.findCommodityByCid();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 52:// 4
				// �����Ʒ�����ﳵ
				ev.addCommodityToCart();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 53:// 5
				// ��ӵ���Ʒ�б�
				ev.findMyAllCartItem();
				TSUtility.readReturn();
				ev.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			}
		}
	}

	//���ҹ��ﳵ��������Ʒ
	private void findMyAllCartItem() {
		// ��ӡ��ͷ��Ϣ
		pfl(fmt(8, "���") + fmt(22, "��Ʒ����") + fmt(10, "�۸�") + fmt(6, "����") + fmt(6, "С��"));

		// ��ȡ���й��ﳵ����
		Map<Commodity, Integer> map = cs.findAll();
		Iterator<Entry<Commodity, Integer>> it = map.entrySet().iterator();
		
		//���ͳ���ܼ�
		Double totalPrice = 0.0;
		
		//ѭ�������������������Լ��Ĺ��ﳵ��Ʒ
		while (it.hasNext()) {
			Entry<Commodity, Integer> entry = it.next();
			Commodity cm = entry.getKey();
			
			//�ܼ��ۼ�
			Double itemPrice = cm.getPrice() * entry.getValue();
			totalPrice += itemPrice;
			
			//������ﳵ��Ʒ
			pf(fmt(8, cm.getCmId()) + fmt(22, cm.getName()) + fmt(10, cm.getCount()) + fmt(6,entry.getValue()) + fmt(6, itemPrice));
			pfl("");// ����
			
		}
		pfl("�ܼ�: " + totalPrice);
	}

	//�����Ʒ�����ﳵ��
	private void addCommodityToCart() {
		pfl("������Ҫ��ӵ���Ʒ���");
		Long cid = TSUtility.readLong();
		Commodity cm = cms.findById(cid);
		Cart cart = new Cart();
		if (cm == null) {
			pfl("����Ʒ�ı�Ų�����");
			return;
		}
		pfl("������Ҫ���������");
		int count = TSUtility.readInt();

		// ��װ����
		cart.setCartId(getCurrentUserCartID());
		cart.setCmId(cm.getCmId());
		cart.setCount(count);

		cs.add(cart);
		pf("��ӳɹ�,");
	}

	//ͨ��id������Ʒ
	private void findCommodityByCid() {
		pfl("������Ҫ��ѯ����Ʒ���");
		Long cid = TSUtility.readLong();
		Commodity cm = cms.findById(cid);
		if (cm == null) {
			pfl("����Ʒ�ı�Ų�����");
			return;
		}
		
		//��ӡ��Ʒ��Ϣ
		pfl(fmt(8, "���") + fmt(22, "��Ʒ����") + fmt(10, "�۸�") + fmt(10, "��ɫ") + fmt(8, "�ߴ�") + fmt(8, "���"));
		pfl(fmt(8, cm.getCmId()) + fmt(22, cm.getName()) +fmt(10,cm.getPrice())+ fmt(10, cm.getColor()) + fmt(8, cm.getSize())
				+ fmt(8, cm.getCount()));

	}

	// ��������ʾ�����Ʒ���
	public void enterMainMenu() {
		pfl("**********��   ӭ   ��   ��   ��   ��   ��   ��************");
		pfl("                    1.�����Ʒ                              ");
		pfl("                    2.�鿴������Ʒ                            ");
		pfl("                    3.�鿴ָ�������Ʒ                         ");
		pfl("                    4.��ӵ����ﳵ                            ");
		pfl("                    5.��ʾ���ﳵ                             ");
		pfl("                    6.�˳�                                 ");
		pfl("*********************************************************");
		pfl("��ѡ��˵�");
	}

	//�г�������Ʒ
	private void listAllCommodity() {
		// ��ӡ��ͷ��Ϣ
		pfl(fmt(8, "���") + fmt(22, "��Ʒ����") + fmt(10, "�۸�") + fmt(10, "��ɫ") + fmt(8, "�ߴ�") + fmt(8, "���"));

		// ��ȡ����Ա�����ݱ�
		Commodity[] commodities = cms.findAll();

		// ͨ��������ӡ������Ա����Ϣ
		for (int i = 0; i < commodities.length; i++) {
			Commodity e = commodities[i];
			String name = e.getName();

			//��ӡ��Ʒ
			pf(fmt(8, e.getCmId()) + fmt(22, e.getName())+ fmt(10,e.getPrice())+ fmt(10, e.getColor()) + fmt(8, e.getSize())
					+ fmt(8, e.getCount()));
			pfl("");// ����
		}
	}

	
	//�����Ʒ
	private void addCommodity() {
		Commodity cm = new Commodity();
		pfl("��������Ʒ���");
		cm.setCmId(TSUtility.readLong());
		pfl("��������Ʒ����");
		cm.setName(TSUtility.readLine());
		pfl("��������Ʒ�۸�");
		cm.setPrice(TSUtility.readDouble());
		pfl("��������Ʒ��ɫ");
		cm.setColor(TSUtility.readLine());
		pfl("��������Ʒ�ߴ�");
		cm.setSize(TSUtility.readInt());
		pfl("��������Ʒ���");
		cm.setCount(TSUtility.readInt());
		cms.add(cm);
		pf("��ӳɹ�.");
	}

	/*
	 * System.out.print�ļ�д����ӡ��Ϣ������
	 * 
	 * @param Ҫ��ӡ����Ϣ
	 */
	private <T> void pf(T x) {
		System.out.print(x);
	}

	/*
	 * System.out.println�ļ�д����ӡ��Ϣ����
	 * 
	 * @param Ҫ��ӡ����Ϣ
	 */
	private <T> void pfl(T x) {
		System.out.println(x);
	}

	/*
	 * * ������ʽ����������ַ���
	 * 
	 * @param length �ַ�������
	 * 
	 * @param message �ַ�����Ϣ
	 * 
	 * @return �����ַ���
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
	 * ������ʽ����������ַ���
	 * 
	 * @param length �ַ�������
	 * 
	 * @param message �ַ�����Ϣ
	 * 
	 * @return �����ַ���
	 */
	private <T> String fmt2(int length, T message) {

		return String.format("%-" + length + "s", message);
	}

	public static Long getCurrentUserCartID() {
		return 1l;
	}
}
