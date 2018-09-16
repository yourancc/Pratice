package cn.yourancc.jd.junit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import org.junit.Test;

public class PrTest {

	
	@Test
	public void test() {
		String str = "Hello World";
		FileWriter fw = null;
		try {
			fw = new FileWriter("Cart.data"); // 1
			fw.write(str);                     // 2
		} catch (IOException e) {
			e.printStackTrace();                // 3
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                        // 4
		}
	}
}
