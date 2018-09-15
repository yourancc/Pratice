package cn.yourancc.pre5.pojo.euqipment;

public class NoteBook implements Equipment {

	private String model;
	private double price;
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getDescription() {
		return model + "(" + price + ")";

	}

	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}


}
