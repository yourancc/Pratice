package cn.yourancc.jd.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.yourancc.jd.dao.CartDao;
import cn.yourancc.jd.model.Cart;
import cn.yourancc.jd.model.Commodity;
import cn.yourancc.jd.view.EntryView;

public class CartDaoImpl implements CartDao{
	public List<Cart> list = new ArrayList<>();
	@Override
	public void add(Cart cart) {
		for(Cart c : list) {
			if(c.getCmId() == cart.getCmId()) {
				//������ﳵ�����и���Ʒ�������ϲ�������
				c.setCount(c.getCount() +cart.getCount());
				return;
			}
		}
		list.add(cart);
	}

	@Override
	public Cart[] findAll() {

		return (Cart[]) list.toArray();
	}

	@Override
	public ArrayList<Cart> findById(Long id) {
		ArrayList<Cart> al = new ArrayList<>();
		Iterator<Cart> it = list.iterator();
		while(it.hasNext()) {
			Cart cart = it.next();
			//������ﳵ�����Լ� ����ӵ�arraylist��
			if(cart.getCartId().equals(EntryView.getCurrentUserCartID())) {
				al.add(cart);
			}
		}

		return al;
	}

	@Override
	public void saveAll() throws FileNotFoundException, IOException {
		
		//�������������
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./Cart.data")));
		
		//��д�뵱ǰmap������Ԫ�ظ���
		oos.writeInt(list.size());
		 Iterator<Cart> it = list.iterator();
		//����д��ÿ��Ԫ��
		while(it.hasNext()) {
			oos.writeObject(it.next());
		}
		//�ر�
		oos.flush();
		oos.close();
	}

	@Override
	public void readAll() throws FileNotFoundException, IOException, ClassNotFoundException {
		//�������������
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./Cart.data")));
		
		//��д�뵱ǰmap������Ԫ�ظ���
		int count = ois.readInt();
		for(int i=0; i<count; i++) {
			Cart cm = (Cart) ois.readObject();
			list.add(cm);
		}
		ois.close();
	}

}
