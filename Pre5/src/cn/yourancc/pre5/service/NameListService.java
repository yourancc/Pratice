package cn.yourancc.pre5.service;

import cn.yourancc.pre5.data.Data;
import cn.yourancc.pre5.pojo.occupation.Employee;
import cn.yourancc.pre5.utils.BeanUtils;

/**
 * 与职员信息相关的服务
 * @author 悠然
 *
 */
public class NameListService {
	private Employee[] employees;
	
	
	/*根据项目提供的Data类构建相应大小的employees数组
	再根据Data类中的数据构建不同对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Eqipment子类的对象
	将对象存于数组中*/
	public NameListService() {
		//1.根据提供的数据创建员工数组
		employees = new Employee[Data.EMPLOYEES.length];
		for(int i=0; i<Data.EMPLOYEES.length; i++) {
			//2.为每一位员工绑定Data类中提供的数据
			employees[i] = BeanUtils.EmployeeFactory(Data.EMPLOYEES[i],Data.EQIPMENTS[i]);
		}
	}
	
	/* 获取当前所有员工。返回：包含所有员工对象的数组 */
	public Employee[] getAllEmployees(){

		return employees;
	}
	
	/*方法：获取指定ID的员工对象。
参数：指定员工的ID
返回：指定员工对象
异常：找不到指定的员工
	 */
	public Employee getEmplyee(int id) throws TeamException{
		Employee e = null;
		
		//1.通过for循环查找与指定id相同的员工，跳出循环
		for(int i=0; i<employees.length ;i++) {
			if(employees[i].getId() == id) {
				e = employees[i];
				break;
			}
		}
		
		return e;
	}
}
