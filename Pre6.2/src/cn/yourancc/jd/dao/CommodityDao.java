package cn.yourancc.jd.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import cn.yourancc.jd.model.Commodity;

public interface CommodityDao {

	public void add(Commodity cm);
	public Commodity[] findAll();
	public Commodity findById(Long l);
	public void saveAll() throws FileNotFoundException, IOException;
	public void readAll() throws FileNotFoundException, IOException, ClassNotFoundException;
}
