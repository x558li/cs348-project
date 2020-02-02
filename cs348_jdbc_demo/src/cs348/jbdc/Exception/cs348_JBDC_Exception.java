package cs348.jbdc.Exception;

import java.util.ArrayList;

public class cs348_JBDC_Exception {
	
	public static void main(String[] args) { 
		
//		try {
//			// list 目前为空，因为还没有new，是不能使用的
//			ArrayList<Integer> list = null;
//			list.add(34);
//			list.add(344);
//		} catch (NullPointerException e) {
//			System.out.println("Null pointer exception");
//			throw e;
		try {
			test(19);
			test(200);
			test(0);
			test(-10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		public static void test(int age) throws Exception {
			if (age >= 0 && age < 18) {
				System.out.println("未成年");
			} else if (age >= 18 && age <= 150) {
				System.out.println("成年人");
			} else {
				throw new Exception("input invalid");
		}
	}
	
}
