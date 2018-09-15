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
	Customer[] customers; //用来保存客户对象的数组
	int total = 0;		//总容量大小
	int curamount = 0;  //当前存放对象个数
	
	/***
	 * 构造方法，参数为初始容量大小
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
	 * 添加客户
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
	 * 替换对象
	 * @param index 需要替换的id
	 * @param cust  替换的对象
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
	 * 删除目标id对象
	 * @param index 目标id
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
		System.out.println("当前大小" + this.curamount +"最大容量"+ this.total);
		return buffer;
	}
	
	/***
	 * 得到指定id'的对象
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
	 * 增容
	 * @return
	 */
	private boolean increaseMemory() {
		int temTotal = total/2 + total;		//总容量大小
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
