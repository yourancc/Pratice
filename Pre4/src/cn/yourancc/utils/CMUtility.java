package cn.yourancc.utils;



import java.util.Scanner;

/**
 * 操作扫面器的工具类
 * @author Mr.Gao
 */
public class CMUtility {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 读取菜单的选择
	 * 
	 * @return
	 */
	public static char readMenuSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
				System.out.print("选择错误，请重新输入：");
			} else
				break;
		}
		return c;
	}

	/**
	 * 读取单个字符
	 * 
	 * @return
	 */
	public static char readChar() {
		String str = readKeyBoard(1, false);
		return str.charAt(0);
	}

	/**
	 * 读取char类型数据
	 * 
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1, true);
		return (str.length() == 0) ? defaultValue : str.charAt(0);
	}

	/**
	 * 读取int类型的数据
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
				System.out.print("数字输入错误，请重新输入：");
			}
		}
		return n;
	}

	/**
	 * 读取int 值
	 * 
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public static int readInt(int defaultValue) {
		int n;
		for (;;) {
			// 可以读取2位数
			String str = readKeyBoard(2, true);
			if (str.equals("")) {
				return defaultValue;
			}

			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("数字输入错误，请重新输入：");
			}
		}
		return n;
	}
	public static int readInt(int maxNum,int defaultValue) {
		int n;
		for (;;) {
			// 可以读取2位数
			String str = readKeyBoard(2, true);
			if (str.equals("")) {
				return defaultValue;
			}

			try {
				n = Integer.parseInt(str);
				if(n>maxNum) {
					System.out.print("数字输入超出范围，请重新输入：");
				}else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.print("数字输入错误，请重新输入：");
			}
		}
		return n;
	}
	/**
	 * 获取指定长度字符串
	 * 
	 * @param limit
	 * @return
	 */
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}

	/**
	 * 读取字符串，可以传入默认值
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
	 * 读取提交的结果
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
				System.out.print("选择错误，请重新输入：");
			}
		}
		return c;
	}

	/**
	 * 获取指定长度的字符串数据
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
				System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}

	public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
	}
}
