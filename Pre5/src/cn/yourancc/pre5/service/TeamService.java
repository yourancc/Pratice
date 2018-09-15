package cn.yourancc.pre5.service;

import cn.yourancc.pre5.pojo.occupation.Architect;
import cn.yourancc.pre5.pojo.occupation.Designer;
import cn.yourancc.pre5.pojo.occupation.Employee;
import cn.yourancc.pre5.pojo.occupation.Occupation;
import cn.yourancc.pre5.pojo.occupation.Programmer;
import cn.yourancc.pre5.pojo.occupation.Status;


public class TeamService {
	public static int counter = 1;// Ϊ��̬����������Ϊ�����Ŷ�������Ա�Զ������Ŷ��е�ΨһID����memberId������ʾ��Ӧʹ����1�ķ�ʽ��
	public static final int MAX_MEMBER = 6;// ��ʾ�����Ŷ�����Ա��
	public static final int MAX_PROGRAMMER = 3;//�����г���Ա�������
	public static final int MAX_DESIGNER = 2;//���������ʦ�������
	public static final int MAX_ARCHITECT = 1;//�����мܹ�ʦ�������
	private int cur_programmer = 0;
	private int cur_designer = 0;
	private int cur_architect = 0;
	private Programmer[] team = new Programmer[MAX_MEMBER];// �����������浱ǰ�Ŷ��еĸ���Ա����
	int total = 0; // ��¼�Ŷӳ�Ա��ʵ������

	/***
	 * ���������ص�ǰ�Ŷӵ����ж��� ���أ��������г�Ա��������飬�����С���Ա����һ��
	 * 
	 */
	public Programmer[] getTeam() {
		return team;
	}

	/***
	 * ���������Ŷ�����ӳ�Ա
	 * 
	 * @param ����ӳ�Ա�Ķ���
	 * @throws ���ʧ�ܣ�
	 *             TeamException�а�����ʧ��ԭ��
	 */
	public void addMember(Employee e) throws TeamException {
		if (total >= 6) {
			throw new TeamException("������team�����������");
		}
		for (Programmer p : this.team) {
			if (p == null) {
				continue;
			}
			if (p.equals(e)) {
				throw new TeamException("�Ѿ���ӹ��ó�Ա");
			}
		}
		if (e instanceof Architect) {
			if (cur_architect < MAX_ARCHITECT) {
				cur_architect++;
				((Architect) e).setStatus(Status.BUSY);
				this.team[total++] = (Architect) e;
			} else {
				throw new TeamException("�ܹ�ʦ�����������ֵ");
			}
		} else if (e instanceof Designer) {
			if (cur_designer < MAX_DESIGNER) {
				cur_designer++;
				((Designer)e).setStatus(Status.BUSY);
				this.team[total++] = (Designer) e;
			} else {
				throw new TeamException("���ʦ�����������ֵ");
			}
		} else if (e instanceof Programmer) {
			if (cur_programmer < MAX_PROGRAMMER) {
				cur_programmer++;
				((Programmer)e).setStatus(Status.BUSY);
				this.team[total++] = (Programmer) e;
			} else {
				throw new TeamException("����Ա�����������ֵ");
			}
		} else {
			throw new TeamException("Ҫ��ӵ�ְλ����Ϊ����Ա����");
		}

	}

	/***
	 * ���Ŷ���ɾ����Ա
	 * 
	 * @param ��ɾ����Ա��memberId
	 * @throws ɾ��ʧ�ܣ�
	 *             TeamException�а�����ʧ��ԭ�� �ɸ�����Ҫ��������������������ع�������
	 */
	public void removeMember(int memberId) throws TeamException {
		if (total <= 0) {
			throw new TeamException("��team�Ѿ�û����");
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
		throw new TeamException("û���ҵ���id��Ա��");
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
