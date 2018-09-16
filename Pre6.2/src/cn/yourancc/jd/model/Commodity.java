package cn.yourancc.jd.model;

import java.io.Serializable;

import cn.yourancc.jd.model.property.Color;

public class Commodity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long cmId;
	private String name;
	private Double price;
	private String color;
	private Integer Size;
	private Integer count;
	public Long getCmId() {
		return cmId;
	}
	public void setCmId(Long cmId) {
		this.cmId = cmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getSize() {
		return Size;
	}
	public void setSize(Integer size) {
		Size = size;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Commodity [cmId=" + cmId + ", name=" + name + ", price=" + price + ", color=" + color + ", Size=" + Size
				+ ", count=" + count + "]";
	}
	public Commodity() {
		super();
	}
	public Commodity(Long cmId, String name, Double price, String color, Integer size, Integer count) {
		super();
		this.cmId = cmId;
		this.name = name;
		this.price = price;
		this.color = color;
		Size = size;
		this.count = count;
	}


}
