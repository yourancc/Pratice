package cn.yourancc.pre5.utils;


import cn.yourancc.pre5.data.Data;
import cn.yourancc.pre5.pojo.euqipment.Equipment;
import cn.yourancc.pre5.pojo.euqipment.NoteBook;
import cn.yourancc.pre5.pojo.euqipment.PC;
import cn.yourancc.pre5.pojo.euqipment.Printer;
import cn.yourancc.pre5.pojo.occupation.Architect;
import cn.yourancc.pre5.pojo.occupation.Designer;
import cn.yourancc.pre5.pojo.occupation.Employee;
import cn.yourancc.pre5.pojo.occupation.Programmer;

public class BeanUtils {

	public static Employee EmployeeFactory(String[] inform,String[] equInform) {
		Employee e = null;
		switch(Integer.valueOf(inform[0])) {
		case Data.EMPLOYEE:
			e= new Employee(Integer.valueOf(inform[1]), inform[2], 
					Integer.valueOf(inform[3]), Double.valueOf(inform[4]));
			break;
		case Data.PROGRAMMER:
			e= new Programmer(Integer.valueOf(inform[1]), inform[2], 
					Integer.valueOf(inform[3]), Double.valueOf(inform[4]),EquipmentFactory(equInform));
			break;
		case Data.DESIGNER:
			e = new Designer(Integer.valueOf(inform[1]), inform[2], 
					Integer.valueOf(inform[3]), Double.valueOf(inform[4]),EquipmentFactory(equInform),Double.valueOf(inform[5]));
			break;
		case Data.ARCHITECT:
			e = new Architect(Integer.valueOf(inform[1]), inform[2], 
					Integer.valueOf(inform[3]), Double.valueOf(inform[4]),EquipmentFactory(equInform),Double.valueOf(inform[5]),Integer.valueOf(inform[6]));
			break;		
		}
		return e;
	}

	public static Equipment EquipmentFactory(String[] equInform) {
		Equipment e = null;
		switch(Integer.valueOf(equInform[0])) {
		case Data.PC:
			e = new PC(equInform[1],equInform[2]);
			break;
		case Data.PRINTER:
			e = new Printer(equInform[1],equInform[2]);
			break;
		case Data.NOTEBOOK:
			e = new NoteBook(equInform[1],Double.valueOf(equInform[2]));
			break;
		}
		return e;
		
	}
}
