package cn.yourancc.pre5.pojo.euqipment;

public class PC implements Equipment {

	private String model;//机器型号
	private String display;//显示器名称
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + display + ")";
	}

	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}
	

	

}
