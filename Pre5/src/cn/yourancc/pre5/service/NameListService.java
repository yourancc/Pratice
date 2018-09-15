package cn.yourancc.pre5.service;

import cn.yourancc.pre5.data.Data;
import cn.yourancc.pre5.pojo.occupation.Employee;
import cn.yourancc.pre5.utils.BeanUtils;

/**
 * ��ְԱ��Ϣ��صķ���
 * @author ��Ȼ
 *
 */
public class NameListService {
	private Employee[] employees;
	
	
	/*������Ŀ�ṩ��Data�๹����Ӧ��С��employees����
	�ٸ���Data���е����ݹ�����ͬ���󣬰���Employee��Programmer��Designer��Architect�����Լ��������Eqipment����Ķ���
	���������������*/
	public NameListService() {
		//1.�����ṩ�����ݴ���Ա������
		employees = new Employee[Data.EMPLOYEES.length];
		for(int i=0; i<Data.EMPLOYEES.length; i++) {
			//2.ΪÿһλԱ����Data�����ṩ������
			employees[i] = BeanUtils.EmployeeFactory(Data.EMPLOYEES[i],Data.EQIPMENTS[i]);
		}
	}
	
	/* ��ȡ��ǰ����Ա�������أ���������Ա����������� */
	public Employee[] getAllEmployees(){

		return employees;
	}
	
	/*��������ȡָ��ID��Ա������
������ָ��Ա����ID
���أ�ָ��Ա������
�쳣���Ҳ���ָ����Ա��
	 */
	public Employee getEmplyee(int id) throws TeamException{
		Employee e = null;
		
		//1.ͨ��forѭ��������ָ��id��ͬ��Ա��������ѭ��
		for(int i=0; i<employees.length ;i++) {
			if(employees[i].getId() == id) {
				e = employees[i];
				break;
			}
		}
		
		return e;
	}
}
