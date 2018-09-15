package cn.yourancc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import cn.yourancc.model.Customer;

public class FileIOUtils {

	private static int curamount;
	public static int getCuramount() {
		return curamount;
	}

	public static void setCuramount(int curamount) {
		FileIOUtils.curamount = curamount;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		FileIOUtils.total = total;
	}

	private static int total;
	
	public static boolean saveCustListasFile(File file,int curamount,int total,Customer[] custs){
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new FileWriter(file));
			bfw.write(curamount + " " + total);
			bfw.newLine();
			for(int i=0; i<total; i++) {
				if(custs[i] != null) {
					bfw.write(i + " " + custs[i].getString());
					bfw.newLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}finally {
			try {
				bfw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}


		return true;
	}

	public static Customer[] readCustListFile(File file) {
		BufferedReader bfr  = null;
		Customer[]custs = null;
		try {
			bfr = new BufferedReader(new FileReader(file));
			String []arraySize = bfr.readLine().split(" ");
			curamount = Integer.valueOf(arraySize[0]);
			if(curamount == 0) {
				return null;
			}
			total = Integer.valueOf(arraySize[1]);
			custs = new Customer[total];
			String buffer = bfr.readLine();
			while(buffer!=null) {
				String[] inform = buffer.split(" ");
				int pos = Integer.valueOf(inform[0]);
				Customer c = new Customer();
				BeanUtils.CustomerBindData(c, inform);
				custs[pos] = c;
				buffer = bfr.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bfr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return custs;
	}
}
