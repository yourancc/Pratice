package cn.yourancc.model;

public class Customer {
	private String name;//	�ͻ�����
	private char gender;//	�Ա�
	private int age;//	����
	private String phone;//	�绰����
	private String email;//	��������
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
