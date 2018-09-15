package cn.yourancc.pre5.pojo.occupation;

import cn.yourancc.pre5.pojo.euqipment.Equipment;

public class Designer extends Programmer {

	private double bounds;//½±½ð
	
	public double getBounds() {
		return bounds;
	}

	public void setBounds(double bounds) {
		this.bounds = bounds;
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment,double bounds) {
		super(id, name, age, salary, equipment);
		// TODO Auto-generated constructor stub
		this.bounds = bounds;
	}

	@Override
	public String toString() {
		return "Designer [bounds=" + bounds + "]";
	}


}
