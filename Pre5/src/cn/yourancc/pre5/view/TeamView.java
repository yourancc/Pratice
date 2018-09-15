package cn.yourancc.pre5.view;

import java.util.List;
import java.util.Vector;

import cn.yourancc.pre5.pojo.occupation.Architect;
import cn.yourancc.pre5.pojo.occupation.Designer;
import cn.yourancc.pre5.pojo.occupation.Employee;
import cn.yourancc.pre5.pojo.occupation.Programmer;
import cn.yourancc.pre5.service.NameListService;
import cn.yourancc.pre5.service.TeamException;
import cn.yourancc.pre5.service.TeamService;
import cn.yourancc.pre5.utils.TSUtility;

public class TeamView {

	NameListService listSvc = new NameListService();
	TeamService teamSvc = new TeamService();
	List<String> list = new Vector<String>();

	// ��������ʾ�����Ʒ���
	public void enterMainMenu() {
		pfl("--------------------------�����Ŷӵ������------------------------------");
		listAllEmployee();
		pfl("-------------------------------------------------------------------");
		pfl("1-�Ŷ��б� 2-����Ŷӳ�Ա 3-ɾ���Ŷӳ�Ա 4-�˳� ��ѡ��(1-4):_");

	}

	// �Ա����ʽ�г���˾���г�Ա
	public void listAllEmployee() {
		//��ӡ��ͷ��Ϣ
		pfl(fmt(4, "ID") + fmt(8, "����") + fmt(3, "����") + fmt(8, "����") + fmt(9, "ְλ") + fmt(6, "״̬") + fmt(6, "����")
				+ fmt(8, "��Ʊ") + fmt(8, "�����豸"));
		
		//��ȡ����Ա�����ݱ�
		Employee[] employees = listSvc.getAllEmployees();
		
		//ͨ��������ӡ������Ա����Ϣ
		for (int i = 0; i < employees.length; i++) {
			Employee e = employees[i];
			String name = e.getName();
			if (name.length() == 2) {
				name = name + "      ";
			} else {
				name = name + "    ";
			}
			//fmt(8,e.getName())
			pf(fmt(4, e.getId()) + name + fmt(5, e.getAge()) + fmt(10, e.getSalary()));
			//���ٲ�ͬ��ְҵ��ӡ������Ĳ�ͬ������
			if (e instanceof Architect) {
				pf(fmt(8, "�ܹ�ʦ"));
				pf(fmt(8, ((Architect) e).getStatus()));
				pf(fmt(8, ((Architect) e).getBounds()));
				pf(fmt(8, ((Architect) e).getStok()));
				pf(fmt(8, ((Architect) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Designer) {
				pf(fmt(8, "���ʦ"));
				pf(fmt(8, ((Designer) e).getStatus()));
				pf(fmt(8, ((Designer) e).getBounds()));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Designer) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Programmer) {
				pf(fmt(8, "������"));
				pf(fmt(8, ((Programmer) e).getStatus()));
				pf(fmt(8, "0"));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Programmer) e).getEquipment().getDescription()));
				;
			}
			pfl("");//����
		}
	}

	//��������б�˵�
	public void enterTeamList() {
		pfl("--------------------------�����Ŷӵ������------------------------------");
		listAllTeamMember();
		pfl("-------------------------------------------------------------------");
		pfl("1-�Ŷ��б� 2-����Ŷӳ�Ա 3-ɾ���Ŷӳ�Ա 4-�˳� ��ѡ��(1-4):_");
	}
	
	//�г����ж����Ա
	public void listAllTeamMember() {
		//��ӡ��ͷ��Ϣ
		pfl(fmt(4, "ID") + fmt(6, "����") + fmt(5, "����") + fmt(10, "����") + fmt(8, "ְλ") + fmt(8, "״̬") + fmt(8, "����")
				+ fmt(8, "��Ʊ") + fmt(8, "�����豸"));
		//����Ŷ������г���Ա��Ϣ
		Programmer[] team = this.teamSvc.getAll();
		
		//ͨ��ѭ��������ӡ��ÿһ��Ա������Ϣ
		for (int i = 0; i < team.length; i++) {
			Employee e = team[i];
			String name = e.getName();
			//�������Ƴ��ȵĲ�ͬ�ж�����ͬ�����ȵĶ����ַ���  ��eclipse������ʹ��
//			if (name.length() == 2) {
//				name = name + "        ";
//			} else {
//				name = name + "    ";
//			}
			//��ӡ����Ա ��ӵ�е�������
			pf(fmt(4, e.getId()) + fmt(6,e.getName()) + fmt(5, e.getAge()) + fmt(10, e.getSalary()));
			//��ӡÿ��ְҵ���е�������
			if (e instanceof Architect) {
				pf(fmt(8, "�ܹ�ʦ"));
				pf(fmt(8, ((Architect) e).getStatus()));
				pf(fmt(8, ((Architect) e).getBounds()));
				pf(fmt(8, ((Architect) e).getStok()));
				pf(fmt(8, ((Architect) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Designer) {
				pf(fmt(8, "���ʦ"));
				pf(fmt(8, ((Designer) e).getStatus()));
				pf(fmt(8, ((Designer) e).getBounds()));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Designer) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Programmer) {
				pf(fmt(8, "������"));
				pf(fmt(8, ((Programmer) e).getStatus()));
				pf(fmt(8, "0"));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Programmer) e).getEquipment().getDescription()));
				;
			}
			pfl("");
		}
	}

	// ʵ����ӳ�Ա����
	public void addMember() {
		int memberID = 0;
		Employee employee = null;
		try {
			pfl("--------------------------��ӳ�Ա------------------------------");
			pf("������Ҫ��ӵĳ�ԱID:");
			memberID = TSUtility.readInt();
			// ����Ա������ȡ��Ա��
			employee = listSvc.getEmplyee(memberID);
			// ��Ա����ӵ�team����
			this.teamSvc.addMember(employee);
			pfl("��ӳɹ�");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("���ʧ��,ԭ��:" + e.getMessage());
		}
	}

	// ʵ��ɾ����Ա����
	public void deleteMember() {
		int memberID = 0;
		try {
			pfl("--------------------------ɾ����Ա------------------------------");
			pfl("������Ҫ��ӵĳ�ԱID:");
			memberID = TSUtility.readInt();
			pf("ȷ���Ƿ�Ҫɾ����Y/N����");
			if (TSUtility.readConfirmSelection() == 'Y') {
				this.teamSvc.removeMember(memberID);
			}
		} catch (Exception e) {
			System.out.println("ɾ��ʧ��,ԭ��:" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
		char selectNumber = TSUtility.readMenuSelection();
		while(selectNumber != 52) {
			switch(selectNumber) {
			case 49:
				tv.enterTeamList();
				TSUtility.readReturn();
				tv.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 50:
				tv.addMember();
				TSUtility.readReturn();
				tv.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			case 51:
				tv.deleteMember();
				TSUtility.readReturn();
				tv.enterMainMenu();
				selectNumber = TSUtility.readMenuSelection();
				break;
			}
		}
	}

	/**
	 * System.out.print�ļ�д����ӡ��Ϣ������
	 * @param Ҫ��ӡ����Ϣ
	 */
	private <T> void pf(T x) {
		System.out.print(x);
	}

	/**
	 * System.out.println�ļ�д����ӡ��Ϣ����
	 * @param Ҫ��ӡ����Ϣ
	 */
	private <T> void pfl(T x) {
		System.out.println(x);
	}

	
	
	/**
	 * ������ʽ����������ַ���
	 * @param length �ַ�������
	 * @param message �ַ�����Ϣ
	 * @return �����ַ���
	 */
	@SuppressWarnings("unused")
	private <T> String fmt2(int length, T message) {
		StringBuffer sb = new StringBuffer(message.toString());
		for (int i = 0; i < length - message.toString().length(); i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	/**
	 * ������ʽ����������ַ���
	 * @param length �ַ�������
	 * @param message �ַ�����Ϣ
	 * @return �����ַ���
	 */
	private <T> String fmt(int length, T message) {
		return String.format("%-" + length + "s", message);
	}
}
