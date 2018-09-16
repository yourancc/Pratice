package cn.yourancc.jd.model;

import cn.yourancc.jd.model.property.Color;

public class Commodity{

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


}
