package cn.yourancc.jd.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.yourancc.jd.dao.CommodityDao;
import cn.yourancc.jd.model.Commodity;

public class CommodityDaoImpl implements CommodityDao{

	public Map<String,Commodity> map = new HashMap<>();
	
	@Override
	public void add(Commodity cm) {
		map.put(cm.getCmId().toString(), cm);
	}

	@Override
	public Commodity[] findAll() {
		int len = map.size();
		Commodity[] commodities = new Commodity[len];
		int i=0;
		Iterator<Commodity> it = map.values().iterator();
		while(it.hasNext()) {
			commodities[i++] =it.next();
		}
		return commodities;
	}

	@Override
	public Commodity findById(Long l) {
		Commodity cm = map.get(l.toString());
		return cm;
	}

	@Override
	public void saveAll() throws FileNotFoundException, IOException {
		
		//�������������
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./Commodity.data")));
		
		//��д�뵱ǰmap������Ԫ�ظ���
		oos.writeInt(map.size());
		Iterator<String> it = map.keySet().iterator();
		//����д��ÿ��Ԫ��
		while(it.hasNext()) {
			oos.writeObject(map.get(it.next()));
		}
		//�ر�
		oos.flush();
		oos.close();
	}

	@Override
	public void readAll() throws FileNotFoundException, IOException, ClassNotFoundException {
		//�������������
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./Commodity.data")));
		
		//��д�뵱ǰmap������Ԫ�ظ���
		int count = ois.readInt();
		for(int i=0; i<count; i++) {
			Commodity cm = (Commodity) ois.readObject();
			map.put(cm.getCmId().toString(), cm);
		}
		ois.close();
	}

	

}
