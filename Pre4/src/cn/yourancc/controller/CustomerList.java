package cn.yourancc.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import cn.yourancc.model.Customer;
import cn.yourancc.utils.FileIOUtils;

public class CustomerList {
	public static final String FILENAME = "./Message";
	Customer[] customers; //��������ͻ����������
	int total = 0;		//��������С
	int curamount = 0;  //��ǰ��Ŷ������
	
	/***
	 * ���췽��������Ϊ��ʼ������С
	 * @param totalCustomer
	 */
	public CustomerList(String filename2,int totalCustomer) {
		customers = getInformByFile(filename2);
		curamount = FileIOUtils.getCuramount();
		total = FileIOUtils.getTotal();
		if(customers == null) {
			customers = new Customer[totalCustomer];
			total = totalCustomer;
		}
		
	}
	
	/***
	 * ��ӿͻ�
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(Customer customer) {
		if(curamount >= total) {
			increaseMemory();
		}
		for(int i=0; i<total; i++){
			if(customers[i]==null) {
				customers[i] = customer;
				curamount++;
				break;
			}
		}
		return true;
	}
	
	/***
	 * �滻����
	 * @param index ��Ҫ�滻��id
	 * @param cust  �滻�Ķ���
	 * @return
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if(index <0 || index > total) {
			return false;
		}
		for(int i=0; i<total; i++) {
			if(i == index) {
				customers[i] = cust;
			}
		}
		return true;
	}
	
	/***
	 * ɾ��Ŀ��id����
	 * @param index Ŀ��id
	 * @return
	 */
	public boolean deleteCustomer(int index) {
		if(index <0 || index > total) {
			return false;
		}
		if(customers[index]!= null) {
			customers[index] = null;
			curamount--;
		}
		return true;		
	}
	public Customer[] getAllCustomers() {
		Customer[] buffer = new Customer[curamount];
		int j=0;
		for(int i=0; i<total; i++) {
			if(customers[i] != null) {
				buffer[j++] = customers[i];
			}
		}
		System.out.println("��ǰ��С" + this.curamount +"�������"+ this.total);
		return buffer;
	}
	
	/***
	 * �õ�ָ��id'�Ķ���
	 * @param index
	 * @return
	 */
	public Customer getCustomer(int index) {
		Customer c = null;
		if(index <0 || index > total) {
			return null;
		}
		for(int i=0; i<total; i++) {
			if(i == index && customers[i]!= null) {
				c = customers[i];
			}else {
				return null;
			}
		}
		return c;		
	}
	
	/***
	 * ����
	 * @return
	 */
	private boolean increaseMemory() {
		int temTotal = total/2 + total;		//��������С
		try {
			Customer[] tempCs = new Customer[temTotal];
			System.arraycopy(customers , 0, tempCs,0, total);;
			customers = tempCs;
			total = temTotal;
		}catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean saveAsFile(String filename2) {
		try {
			File file = new File(filename2);
			if(file.exists()) {
				file.delete();
			}
			file.createNewFile();
			file.setWritable(true);
			FileIOUtils.saveCustListasFile(file,curamount,total,customers);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub
		
	}
	
	public Customer[] getInformByFile(String filename2) {
		try {
			File file = new File(filename2);
			if(!file.exists()) {
				return null;
			}
			file.setReadable(true);
			return FileIOUtils.readCustListFile(file);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
