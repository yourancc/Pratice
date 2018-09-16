package cn.yourancc.jd.junit;

import org.junit.Test;

import cn.yourancc.jd.utils.TSUtility;

public class InputTest {

	
	@Test
	public void test() {
		fmt(8,"ÎÒ1Äã111");
	}
	
	private <T> String fmt(int length, T message) {
		StringBuffer sb = new StringBuffer(message.toString());
		int count=0;
		System.out.println(sb.length());
		for(int i=0; i<sb.length(); i++) {
			char c = sb.charAt(i);
			if(c>255)
				count++;
			count++;
		}
		if(count>length)
			return sb.toString();
		//System.out.println(count);
		for (; count < length; count++) {
			
			sb.append(" ");
		}
		return sb.toString();
	}
}
