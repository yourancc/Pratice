package cn.yourancc.pre5.utils;

import java.util.*;

public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);
    	/**
    	 * ������Ĳ˵�ֵ����У��
    	 * @return
    	 */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
        	/**
        	 * �ж��Ƿ�Ϊ��λ����ѡ��
        	 */
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            //�����������ֲ���1~4����������
            if (c != '1' && c != '2' &&
                c != '3' && c != '4') {
                System.out.print("ѡ��������������룺");
            } else break;
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
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
        	/*
        	 * 2 ��ʾ������2λ����
        	 */
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
     * ���Ƿ��ύ��ѡ�����У��
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
        	/*1��ֻ������һ��ֵ
        	 * toUpperCase()���������ĸ��Ϊ��д
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
     * @param limit  ����¼�������
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
    }

