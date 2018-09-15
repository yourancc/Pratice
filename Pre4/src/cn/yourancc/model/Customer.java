package cn.yourancc.model;

public class Customer {
	private String name;//	客户姓名
	private char gender;//	性别
	private int age;//	年龄
	private String phone;//	电话号码
	private String email;//	电子邮箱
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + ", age=" + age + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
	public String getString() {
		return name + " " +age  + " " + gender + " " +email  + " " +phone ;
	}
	
	
}
