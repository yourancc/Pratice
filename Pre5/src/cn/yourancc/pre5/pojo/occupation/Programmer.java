package cn.yourancc.pre5.pojo.occupation;

import cn.yourancc.pre5.pojo.euqipment.Equipment;

public class Programmer extends Employee {


	private int memberId;//������¼��Ա���뿪���ŶӺ����Ŷ��е�ID
	private Status status = Status.FREE;//����Ŀ�Զ����ö�����ͣ���ʾ��Ա��״̬��
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
