package cn.yourancc.pre5.junit;

import org.junit.Before;
import org.junit.Test;

import cn.yourancc.pre5.utils.TSUtility;

public class ServiceTest {
	
	@Before
	public void before() {
		;
	}
	
	@Test
	public void test1() {
		
		//new NameListService().getAllEmployees();
		System.out.println(TSUtility.readConfirmSelection());;
	}
}
