package cn.yourancc.view;

import cn.yourancc.controller.CustomerList;
import cn.yourancc.model.Customer;
import cn.yourancc.utils.BeanUtils;
import cn.yourancc.utils.CMUtility;

public class CustomerView {
	private CustomerList customerlist = new CustomerList(CustomerList.FILENAME,2);  
	public void enterMainMenu() {
		System.out.println("---------------客户信息管理软件------------");
		System.out.println("               1.添  加  客  户                                               ");
		System.out.println("               2.修  改  客  户                                               ");
		System.out.println("               3.删  除  客  户                                               ");
		System.out.println("               4.客  户  列  表                                               ");
		System.out.println("               5.退               出                                               ");
		System.out.println("               请选择（1-5）                                             ");
		System.out.println("-------------------------------------");
	} 
	
	/***
	 * 添加新的客户
	 */
	public void addNewCustomer() {
		String [] inform = getSplitStringByInform("请以（姓名 年龄 性别 邮箱 电话 ）形式输入（空格分割）如：张三 19 男 10032@qq.com 1873333",1024," ");
		//如果输入的数据不对，则返回
		if(inform.length != 5) {
			System.out.println("输入的数据有误！");
			return;
		}
		Customer c = new Customer();
		BeanUtils.CustomerBindData(c, inform);
		textOutInform(customerlist.addCustomer(c),"添加成功！, ","添加失败！, ");
		
	} 
	
	/***
	 * 修改客户
	 */
	private void modifyCustomer() {
		String [] inform =  getSplitStringByInform("请以以下格式（id 姓名 年龄 性别 邮箱 电话 ）形式输入(空格为分隔符)如：1 张三 19 男 10032@qq.com 1873333" , 1024, " ");
		//如果输入的数据不对
		if(inform.length != 6) {
			System.out.println("输入的数据有误！");
			return;
		}
		Customer c = new Customer();
		//绑定Bean数据
		BeanUtils.CustomerBindData(c, inform);
		textOutInform(customerlist.replaceCustomer(Integer.valueOf(inform[0]), c),"修改成功！, ","修改失败！, ");
	}
	/***
	 * 删除客户
	 */
	private void deleteCustomer() {
		System.out.println("请输入要删除的id");
		int id = CMUtility.readInt();
		textOutInform(customerlist.deleteCustomer(id),"删除成功！, ","删除失败！ ");		
	}
	/***
	 * 遍历客户
	 */
	private void listAllCustomers() {
		
		Customer[] cs = customerlist.getAllCustomers();
		for(int i=0; i<cs.length; i++) {
			System.out.println(cs[i]);;
		}
		textOutInform(true,"遍历完成， ","遍历完成， ");
	}
//	public void enterMainMenu(); 
	public static void main(String[] args) {
		CustomerView cv = new CustomerView();
		cv.enterMainMenu();
		int num = CMUtility.readInt(5,4);
		while(num != 255) {
			switch(num) {
			case 1://添加
				cv.addNewCustomer();
				
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);
				break;
			case 2://修改
				cv.modifyCustomer();
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);				
				break;
			case 3://删除4
				cv.deleteCustomer();
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);
				break;
			case 4://遍历
				cv.listAllCustomers();
				cv.enterMainMenu();
				num = CMUtility.readInt(5,4);
				break;
			case 5://退出
				cv.saveAsFile();
				num =255;
				break;
			default:
				System.out.println("其他");
				break;
			}			
		}

	}

	
	private boolean saveAsFile() {
		customerlist.saveAsFile(CustomerList.FILENAME);
		return true;
	}

	//根据提示分割字符串，参数1为提示内容，参数2为缓存区大小
	private String[] getSplitStringByInform(String title,int bufferSize,String splitStr) {
		System.out.println(title);
		String strBuffer=CMUtility.readString(bufferSize);
		String [] inform = strBuffer.split(splitStr);
		return inform;
	}
	//根据传入参数判断要输出的内容
	private void textOutInform(boolean f,String s1,String s2) {
		if(f) {
			System.out.print(s1);
		}else {
			System.out.print(s2);
		}
        CMUtility.readReturn();
	}
}
