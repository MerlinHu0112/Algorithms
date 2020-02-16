package algorithms.search.binary_search;

import org.junit.Test;

// 测试BinarySearchST
public class TestST {
	
	@Test
	public void function() {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(20);
		st.put("S", 0);
		st.put("E", 1);
		st.put("A", 2);
		st.put("R", 3);
		st.put("C", 4);
		st.put("H", 5);
		st.put("E", 6);
		st.put("X", 7);
		st.put("A", 8);
		st.put("M", 9);
		st.put("P", 10);
		st.put("L", 11);
		st.put("E", 12);
		
		System.out.println("键'E'对应的值为："+st.get("E"));
		System.out.println("符号表的大小为："+st.size());
		System.out.print("符号表是否含有键'A':");
		if (st.contains("A")==true) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		System.out.println("符号表最大的键为："+st.max()+",最小的键为："+st.min());
		
		String targetKey_Floor = "A"; // A、F、Z
		System.out.println("小于或等于键'"+targetKey_Floor+"'的最大的键为："+st.floor(targetKey_Floor));
		
		String targetKey_Ceiling = "Z";
		System.out.println("大于或等于键'"+targetKey_Ceiling+"'的最小的键为："+st.ceiling(targetKey_Ceiling));
	}
}
