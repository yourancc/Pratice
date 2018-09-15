package cn.yourancc.pre5.service;

import cn.yourancc.pre5.pojo.occupation.Architect;
import cn.yourancc.pre5.pojo.occupation.Designer;
import cn.yourancc.pre5.pojo.occupation.Employee;
import cn.yourancc.pre5.pojo.occupation.Occupation;
import cn.yourancc.pre5.pojo.occupation.Programmer;
import cn.yourancc.pre5.pojo.occupation.Status;


public class TeamService {
	public static int counter = 1;// 为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
	public static final int MAX_MEMBER = 6;// 表示开发团队最大成员数
	public static final int MAX_PROGRAMMER = 3;//队伍中程序员最大人数
	public static final int MAX_DESIGNER = 2;//队伍中设计师最大人数
	public static final int MAX_ARCHITECT = 1;//队伍中架构师最大人数
	private int cur_programmer = 0;
	private int cur_designer = 0;
	private int cur_architect = 0;
	private Programmer[] team = new Programmer[MAX_MEMBER];// 数组用来保存当前团队中的各成员对象
	int total = 0; // 记录团队成员的实际人数

	/***
	 * 方法：返回当前团队的所有对象 返回：包含所有成员对象的数组，数组大小与成员人数一致
	 * 
	 */
	public Programmer[] getTeam() {
		return team;
	}

	/***
	 * 方法：向团队中添加成员
	 * 
	 * @param 待添加成员的对象
	 * @throws 添加失败，
	 *             TeamException中包含了失败原因
	 */
	public void addMember(Employee e) throws TeamException {
		if (total >= 6) {
			throw new TeamException("超过该team最大允许人数");
		}
		for (Programmer p : this.team) {
			if (p == null) {
				continue;
			}
			if (p.equals(e)) {
				throw new TeamException("已经添加过该成员");
			}
		}
		if (e instanceof Architect) {
			if (cur_architect < MAX_ARCHITECT) {
				cur_architect++;
				((Architect) e).setStatus(Status.BUSY);
				this.team[total++] = (Architect) e;
			} else {
				throw new TeamException("架构师人数超过最大值");
			}
		} else if (e instanceof Designer) {
			if (cur_designer < MAX_DESIGNER) {
				cur_designer++;
				((Designer)e).setStatus(Status.BUSY);
				this.team[total++] = (Designer) e;
			} else {
				throw new TeamException("设计师人数超过最大值");
			}
		} else if (e instanceof Programmer) {
			if (cur_programmer < MAX_PROGRAMMER) {
				cur_programmer++;
				((Programmer)e).setStatus(Status.BUSY);
				this.team[total++] = (Programmer) e;
			} else {
				throw new TeamException("程序员人数超过最大值");
			}
		} else {
			throw new TeamException("要添加的职位至少为程序员以上");
		}

	}

	/***
	 * 从团队中删除成员
	 * 
	 * @param 待删除成员的memberId
	 * @throws 删除失败，
	 *             TeamException中包含了失败原因 可根据需要自行添加其他方法或重载构造器。
	 */
	public void removeMember(int memberId) throws TeamException {
		if (total <= 0) {
			throw new TeamException("该team已经没人了");
		}

		for (int i = 0; i < total; i++) {
			if (team[i].getId() == memberId) {
				team[i].setStatus(Status.FREE);
				switch (getType(team[i])) {
				case Architect:
					cur_architect--;
					break;
				case Designer:
					cur_designer--;
					break;
				case Programmer:
					cur_programmer--;
					break;
				default:
					break;
				}
				team[i] = null;
				total--;
				return;
			}
		}
		throw new TeamException("没有找到该id的员工");
	}

	public Programmer[] getAll() {
		Programmer tempProgrammer[] = new Programmer[total]; 
		int i=0;
		for(int j=0; j<MAX_MEMBER; j++) {
			if(team[j] != null) {
				tempProgrammer[i++] = team[j];
			}
		}
		return tempProgrammer;
	}

	private Occupation getType(Employee e) {
		if (e instanceof Architect) {
			return Occupation.Architect;
		} else if (e instanceof Designer) {
			return Occupation.Designer;
		} else if (!(e instanceof Programmer)) {
			return Occupation.Programmer;
		} else {
			return Occupation.Employee;
		}
	}
}
