package algorithms.search.sequential_search;
import org.junit.Test;

// 测试符号表
@SuppressWarnings("all")
public class TestST {

	@Test
	public void function() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST();
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
		//st.put("A", null); // 延时删除
		st.delete("A"); // 直接删除
		System.out.print("执行删除操作后，符号表是否仍含有键'A':");
		if (st.contains("A")==true) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		System.out.println("符号表的大小为："+st.size());
	}
}
