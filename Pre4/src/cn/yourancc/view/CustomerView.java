package cn.yourancc.view;

import cn.yourancc.controller.CustomerList;
import cn.yourancc.model.Customer;
import cn.yourancc.utils.BeanUtils;
import cn.yourancc.utils.CMUtility;

public class CustomerView {
	private CustomerList customerlist = new CustomerList(CustomerList.FILENAME,2);  
	public void enterMainMenu() {
		System.out.println("---------------�ͻ���Ϣ�������------------");
		System.out.println("               1.��  ��  ��  ��                                               ");
		System.out.println("               2.��  ��  ��  ��                                               ");
		System.out.println("               3.ɾ  ��  ��  ��                                               ");
		System.out.println("               4.��  ��  ��  ��                                               ");
		System.out.println("               5.��               ��                                               ");
		System.out.println("               ��ѡ��1-5��                                             ");
		System.out.println("-------------------------------------");
	} 
	
	/***
	 * ����µĿͻ�
	 */
	public void addNewCustomer() {
		String [] inform = getSplitStringByInform("���ԣ����� ���� �Ա� ���� �绰 ����ʽ���루�ո�ָ�磺���� 19 �� 10032@qq.com 1873333",1024," ");
		//�����������ݲ��ԣ��򷵻�
		if(inform.length != 5) {
			System.out.println("�������������");
			return;
		}
		Customer c = new Customer();
		BeanUtils.CustomerBindData(c, inform);
		textOutInform(customerlist.addCustomer(c),"��ӳɹ���, ","���ʧ�ܣ�, ");
		
	} 
	
	/***
	 * �޸Ŀͻ�
	 */
	private void modifyCustomer() {
		String [] inform =  getSplitStringByInform("�������¸�ʽ��id ���� ���� �Ա� ���� �绰 ����ʽ����(�ո�Ϊ�ָ���)�磺1 ���� 19 �� 10032@qq.com 1873333" , 1024, " ");
		//�����������ݲ���
		if(inform.length != 6) {
			System.out.println("�������������");
			return;
		}
		Customer c = new Customer();
		//��Bean����
		BeanUtils.CustomerBindData(c, inform);
		textOutInform(customerlist.replaceCustomer(Integer.valueOf(inform[0]), c),"�޸ĳɹ���, ","�޸�ʧ�ܣ�, ");
	}
	/***
	 * ɾ���ͻ�
	 */
	private void deleteCustomer() {
		System.out.println("������Ҫɾ����id");
		int id = CMUtility.readInt();
		textOutInform(customerlist.deleteCustomer(id),"ɾ���ɹ���, ","ɾ��ʧ�ܣ� ");		
	}
	/***
	 * �����ͻ�
	 */
	private void listAllCustomers() {
		
		Customer[] cs = customerlist.getAllCustomers();
		for(int i=0; i<cs.length; i++) {
			System.out.println(cs[i]);;
		}
		textOutInform(true,"������ɣ� ","������ɣ� ");
	}
//	public void enterMainMenu(); 
	public static void main(String[] args) {
		CustomerView cv = new CustomerView();
		cv.enterMainMenu();
		int num = CMUtility.readInt(5,4);
		while(num != 255) {
			switch(num) {
			case 1://���
				cv.addNewCustomer();
				
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);
				break;
			case 2://�޸�
				cv.modifyCustomer();
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);				
				break;
			case 3://ɾ��4
				cv.deleteCustomer();
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);
				break;
			case 4://����
				cv.listAllCustomers();
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);
				break;
			case 5://�˳�
				cv.saveAsFile();
				num =255;
				break;
			default:
				System.out.println("����");
				break;
			}			
		}

	}

	
	private boolean saveAsFile() {
		customerlist.saveAsFile(CustomerList.FILENAME);
		return true;
	}

	//������ʾ�ָ��ַ���������1Ϊ��ʾ���ݣ�����2Ϊ��������С
	private String[] getSplitStringByInform(String title,int bufferSize,String splitStr) {
		System.out.println(title);
		String strBuffer=CMUtility.readString(bufferSize);
		String [] inform = strBuffer.split(splitStr);
		return inform;
	}
	//���ݴ�������ж�Ҫ���������
	private void textOutInform(boolean f,String s1,String s2) {
		if(f) {
			System.out.print(s1);
		}else {
			System.out.print(s2);
		}
        CMUtility.readReturn();
	}
}
