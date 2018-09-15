package cn.yourancc.utils;

import cn.yourancc.model.Customer;

public class BeanUtils {
	public static void CustomerBindData(Customer c,String [] inform) {
		//姓名 年龄 性别 邮箱 电话
		if(inform.length == 5){
			c.setName(inform[0]);
			c.setAge(Integer.valueOf(inform[1]));
			c.setGender(inform[2].charAt(0));
			c.setEmail(inform[3]);
			c.setPhone(inform[4]);
		}else if(inform.length == 6) {
			c.setName(inform[1]);
			c.setAge(Integer.valueOf(inform[2]));
			c.setGender(inform[3].charAt(0));
			c.setEmail(inform[4]);
			c.setPhone(inform[5]);			
		}
	}
}
