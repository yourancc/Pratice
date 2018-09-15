package cn.yourancc.pre5.pojo.occupation;

import cn.yourancc.pre5.pojo.euqipment.Equipment;

public class Programmer extends Employee {


	private int memberId;//用来记录成员加入开发团队后在团队中的ID
	private Status status = Status.FREE;//是项目自定义的枚举类型，表示成员的状态：
	private Equipment equipment;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Programmer(int id, String name, int age, double salary,Equipment equipment) {
		super(id, name, age, salary);
		// TODO Auto-generated constructor stub
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		return "Programmer [memberId=" + memberId + ", status=" + status + ", equipment=" + equipment + "]";
	}
	
}
