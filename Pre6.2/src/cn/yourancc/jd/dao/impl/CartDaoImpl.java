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
				//如果购物车中已有该商品则讲数量合并并返回
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
			//如果购物车属于自己 则添加到arraylist中
			if(cart.getCartId().equals(EntryView.getCurrentUserCartID())) {
				al.add(cart);
			}
		}

		return al;
	}

	@Override
	public void saveAll() throws FileNotFoundException, IOException {
		
		//创建对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./Cart.data")));
		
		//先写入当前map包含的元素个数
		oos.writeInt(list.size());
		 Iterator<Cart> it = list.iterator();
		//遍历写入每个元素
		while(it.hasNext()) {
			oos.writeObject(it.next());
		}
		//关闭
		oos.flush();
		oos.close();
	}

	@Override
	public void readAll() throws FileNotFoundException, IOException, ClassNotFoundException {
		//创建对象输出流
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./Cart.data")));
		
		//先写入当前map包含的元素个数
		int count = ois.readInt();
		for(int i=0; i<count; i++) {
			Cart cm = (Cart) ois.readObject();
			list.add(cm);
		}
		ois.close();
	}

}
