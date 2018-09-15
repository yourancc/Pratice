package cn.yourancc.junit;

import static org.junit.Assume.assumeNoException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import org.junit.Test;

import cn.yourancc.view.CustomerView;

class Car{
	public void run() {};
	public void stop() {};
	public void slowRun() {};
}

public class TextDemo {
	enum Color{red,blue,yellow};
	
	@Test
	public void test() {
		test2();

	}

	//public static void main(String [] args) {
	public static void tt(){
		Scanner s = new Scanner(System.in);
		String colorStr = s.nextLine();
		Color c = Color.valueOf(colorStr);
		Car car = new Car();
		switch(c) {
		case blue:
			car.run();
			break;
		case red:
			car.stop();
			break;
		case yellow:
			car.slowRun();
			break;
		}
	}

	public void test2 () {
		
		byte i = 127;
		printf(i>>>1);
		printf(1287);
		
	}
	
	private void printf(int i) {
		System.out.println(String.valueOf(i));
	}
	private void printf(byte i) {
		System.out.println(String.valueOf(i));
	}
	public void printf(String s) {
		System.out.println(s);
	}
}


