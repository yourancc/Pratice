package cn.yourancc.utils;



import java.util.Scanner;

/**
 * ����ɨ�����Ĺ�����
 * @author Mr.Gao
 */
public class CMUtility {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * ��ȡ�˵���ѡ��
	 * 
	 * @return
	 */
	public static char readMenuSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
				System.out.print("ѡ��������������룺");
			} else
				break;
		}
		return c;
	}

	/**
	 * ��ȡ�����ַ�
	 * 
	 * @return
	 */
	public static char readChar() {
		String str = readKeyBoard(1, false);
		return str.charAt(0);
	}

	/**
	 * ��ȡchar��������
	 * 
	 * @param defaultValue
	 *            Ĭ��ֵ
	 * @return
	 */
	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1, true);
		return (str.length() == 0) ? defaultValue : str.charAt(0);
	}

	/**
	 * ��ȡint���͵�����
	 * 
	 * @return
	 */
	public static int readInt() {
		int n;
		for (;;) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("��������������������룺");
			}
		}
		return n;
	}

	/**
	 * ��ȡint ֵ
	 * 
	 * @param defaultValue
	 *            Ĭ��ֵ
	 * @return
	 */
	public static int readInt(int defaultValue) {
		int n;
		for (;;) {
			// ���Զ�ȡ2λ��
			String str = readKeyBoard(2, true);
			if (str.equals("")) {
				return defaultValue;
			}

			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("��������������������룺");
			}
		}
		return n;
	}
	public static int readInt(int maxNum,int defaultValue) {
		int n;
		for (;;) {
			// ���Զ�ȡ2λ��
			String str = readKeyBoard(2, true);
			if (str.equals("")) {
				return defaultValue;
			}

			try {
				n = Integer.parseInt(str);
				if(n>maxNum) {
					System.out.print("�������볬����Χ�����������룺");
				}else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.print("��������������������룺");
			}
		}
		return n;
	}
	/**
	 * ��ȡָ�������ַ���
	 * 
	 * @param limit
	 * @return
	 */
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}

	/**
	 * ��ȡ�ַ��������Դ���Ĭ��ֵ
	 * 
	 * @param limit
	 * @param defaultValue
	 * @return
	 */
	public static String readString(int limit, String defaultValue) {
		String str = readKeyBoard(limit, true);
		return str.equals("") ? defaultValue : str;
	}

	/**
	 * ��ȡ�ύ�Ľ��
	 * 
	 * @return
	 */
	public static char readConfirmSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if (c == 'Y' || c == 'N') {
				break;
			} else {
				System.out.print("ѡ��������������룺");
			}
		}
		return c;
	}

	/**
	 * ��ȡָ�����ȵ��ַ�������
	 * 
	 * @param limit
	 * @param blankReturn
	 * @return
	 */
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (blankReturn)
					return line;
				else
					continue;
			}

			if (line.length() < 1 || line.length() > limit) {
				System.out.print("���볤�ȣ�������" + limit + "���������������룺");
				continue;
			}
			break;
		}
		return line;
	}

	public static void readReturn() {
        System.out.print("���س�������...");
        readKeyBoard(100, true);
	}
}
