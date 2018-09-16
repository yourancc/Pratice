package cn.yourancc.jd.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TSUtility {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * ������Ĳ˵�ֵ����У��
	 * 
	 * @return
	 */
	public static char readMenuSelection() {
		char c;
		for (;;) {
			/**
			 * �ж��Ƿ�Ϊ��λ����ѡ��
			 */
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			// �����������ֲ���1~4����������
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6') {
				System.out.print("ѡ��������������룺");
			} else
				break;
		}
		return c;
	}

	/**
	 * ���س�����
	 */
	public static void readReturn() {
		System.out.print("���س�������...");
		readKeyBoard(100, true);
	}

	/**
	 * ��ȡint���͵���ֵ
	 * 
	 * @return
	 */
	public static int readInt() {
		int n;
		for (;;) {
			/*
			 * 2 ��ʾ������2λ����
			 */
			String str = readKeyBoard(5, false);
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
	 * ��ȡLong���͵���ֵ
	 * 
	 * @return
	 */
	public static Double readDouble() {
		Double d;
		for (;;) {
			/*
			 * 5 ��ʾ������5λ����
			 */
			String str = readKeyBoard(10, false);
			try {
				d = Double.parseDouble(str);
				// System.out.println(str + " " + d);
				break;
			} catch (NumberFormatException e) {
				System.out.print("��������������������룺");
			}
		}
		return d;
	}

	public static String readLine() {
		String str;
		for (;;) {
			/*
			 * 5 ��ʾ������5λ����
			 */

			try {
				str = readKeyBoard(256, false);
				break;
			} catch (Exception e) {
				System.out.print("��������������������룺");
			}
		}
		return str;
	}

	public static Long readLong() {
		Long l = 0l;
		for (;;) {
			/*
			 * 5 ��ʾ������5λ����
			 */

			try {
				String str = readKeyBoard(8, false);
				l = Long.valueOf(str);
				break;
			} catch (Exception e) {
				System.out.print("��������������������룺");
			}
		}
		return l;
	}

	/**
	 * ���Ƿ��ύ��ѡ�����У��
	 * 
	 * @return
	 */
	public static char readConfirmSelection() {
		char c;
		for (;;) {
			/*
			 * 1��ֻ������һ��ֵ toUpperCase()���������ĸ��Ϊ��д
			 */
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
	 * ����������ݽ���У��
	 * 
	 * @param limit
	 *            ����¼�������
	 * @param blankReturn
	 * @return
	 */
	public static String readKeyBoard(int limit, boolean blankReturn) {
		
		String line = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while (true) {
				line = br.readLine();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return line;
	}
}
