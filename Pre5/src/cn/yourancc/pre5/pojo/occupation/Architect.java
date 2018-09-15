package cn.yourancc.pre5.pojo.occupation;

import cn.yourancc.pre5.pojo.euqipment.Equipment;

public class Architect extends Designer {

	private int stok;//¹ÉÆ±

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bounds,int stok) {
		super(id, name, age, salary, equipment, bounds);
		// TODO Auto-generated constructor stub
		this.stok = stok;
	}

	@Override
	public String toString() {
		return "Architect [stok=" + stok + "]";
	}
	

}
