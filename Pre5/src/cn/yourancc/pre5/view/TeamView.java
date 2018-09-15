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

	// 主界面显示及控制方法
	public void enterMainMenu() {
		pfl("--------------------------开发团队调度软件------------------------------");
		listAllEmployee();
		pfl("-------------------------------------------------------------------");
		pfl("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):_");

	}

	// 以表格形式列出公司所有成员
	public void listAllEmployee() {
		//打印表头信息
		pfl(fmt(4, "ID") + fmt(8, "姓名") + fmt(3, "年龄") + fmt(8, "工资") + fmt(9, "职位") + fmt(6, "状态") + fmt(6, "奖金")
				+ fmt(8, "股票") + fmt(8, "领用设备"));
		
		//获取所有员工数据表
		Employee[] employees = listSvc.getAllEmployees();
		
		//通过遍历打印出所有员工信息
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
			//柑橘不同的职业打印出所需的不同数据项
			if (e instanceof Architect) {
				pf(fmt(8, "架构师"));
				pf(fmt(8, ((Architect) e).getStatus()));
				pf(fmt(8, ((Architect) e).getBounds()));
				pf(fmt(8, ((Architect) e).getStok()));
				pf(fmt(8, ((Architect) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Designer) {
				pf(fmt(8, "设计师"));
				pf(fmt(8, ((Designer) e).getStatus()));
				pf(fmt(8, ((Designer) e).getBounds()));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Designer) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Programmer) {
				pf(fmt(8, "管理者"));
				pf(fmt(8, ((Programmer) e).getStatus()));
				pf(fmt(8, "0"));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Programmer) e).getEquipment().getDescription()));
				;
			}
			pfl("");//换行
		}
	}

	//进入队伍列表菜单
	public void enterTeamList() {
		pfl("--------------------------开发团队调度软件------------------------------");
		listAllTeamMember();
		pfl("-------------------------------------------------------------------");
		pfl("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):_");
	}
	
	//列出所有队伍成员
	public void listAllTeamMember() {
		//打印表头信息
		pfl(fmt(4, "ID") + fmt(6, "姓名") + fmt(5, "年龄") + fmt(10, "工资") + fmt(8, "职位") + fmt(8, "状态") + fmt(8, "奖金")
				+ fmt(8, "股票") + fmt(8, "领用设备"));
		//获得团队中所有程序员信息
		Programmer[] team = this.teamSvc.getAll();
		
		//通过循环便利打印出每一个员工的信息
		for (int i = 0; i < team.length; i++) {
			Employee e = team[i];
			String name = e.getName();
			//根据名称长度的不同判断生成同样长度的定长字符串  在eclipse环境下使用
//			if (name.length() == 2) {
//				name = name + "        ";
//			} else {
//				name = name + "    ";
//			}
			//打印程序员 都拥有的数据项
			pf(fmt(4, e.getId()) + fmt(6,e.getName()) + fmt(5, e.getAge()) + fmt(10, e.getSalary()));
			//打印每种职业特有的数据项
			if (e instanceof Architect) {
				pf(fmt(8, "架构师"));
				pf(fmt(8, ((Architect) e).getStatus()));
				pf(fmt(8, ((Architect) e).getBounds()));
				pf(fmt(8, ((Architect) e).getStok()));
				pf(fmt(8, ((Architect) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Designer) {
				pf(fmt(8, "设计师"));
				pf(fmt(8, ((Designer) e).getStatus()));
				pf(fmt(8, ((Designer) e).getBounds()));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Designer) e).getEquipment().getDescription()));
				;
			} else if (e instanceof Programmer) {
				pf(fmt(8, "管理者"));
				pf(fmt(8, ((Programmer) e).getStatus()));
				pf(fmt(8, "0"));
				pf(fmt(8, "0"));
				pf(fmt(8, ((Programmer) e).getEquipment().getDescription()));
				;
			}
			pfl("");
		}
	}

	// 实现添加成员操作
	public void addMember() {
		int memberID = 0;
		Employee employee = null;
		try {
			pfl("--------------------------添加成员------------------------------");
			pf("请输入要添加的成员ID:");
			memberID = TSUtility.readInt();
			// 从人员名单中取出员工
			employee = listSvc.getEmplyee(memberID);
			// 将员工添加到team队伍
			this.teamSvc.addMember(employee);
			pfl("添加成功");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败,原因:" + e.getMessage());
		}
	}

	// 实现删除成员操作
	public void deleteMember() {
		int memberID = 0;
		try {
			pfl("--------------------------删除成员------------------------------");
			pfl("请输入要添加的成员ID:");
			memberID = TSUtility.readInt();
			pf("确认是否要删除（Y/N）：");
			if (TSUtility.readConfirmSelection() == 'Y') {
				this.teamSvc.removeMember(memberID);
			}
		} catch (Exception e) {
			System.out.println("删除失败,原因:" + e.getMessage());
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
	 * System.out.print的简写，打印信息不换行
	 * @param 要打印的信息
	 */
	private <T> void pf(T x) {
		System.out.print(x);
	}

	/**
	 * System.out.println的简写，打印信息换行
	 * @param 要打印的信息
	 */
	private <T> void pfl(T x) {
		System.out.println(x);
	}

	
	
	/**
	 * 左对齐格式化输出定长字符串
	 * @param length 字符串长度
	 * @param message 字符串信息
	 * @return 定长字符串
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
	 * 左对齐格式化输出定长字符串
	 * @param length 字符串长度
	 * @param message 字符串信息
	 * @return 定长字符串
	 */
	private <T> String fmt(int length, T message) {
		return String.format("%-" + length + "s", message);
	}
}
