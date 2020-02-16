package algorithms.search.binary_search_tree;

import org.junit.Test;

// 用于测试BinarySearchTree类
public class TestBST {

	@Test
	public void function() {
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("A", 2);
		bst.put("R", 3);
		bst.put("C", 4);
		bst.put("H", 5);
		bst.put("E", 6);
		bst.put("X", 7);
		bst.put("A", 8);
		bst.put("M", 9);
		bst.put("P", 10);
		bst.put("L", 11);
		bst.put("E", 12);
		
		System.out.println("键'E'对应的值为："+bst.get("E"));
		System.out.println("符号表的大小为："+bst.size());
		System.out.print("符号表是否含有键'A':");
		if (bst.contains("A")==true) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		System.out.println("符号表最大的键为："+bst.max()+",最小的键为："+bst.min());
		
		String targetKey_Floor = "D";
		System.out.println("小于或等于键'"+targetKey_Floor+"'的最大的键为："+bst.floor(targetKey_Floor));
		
		String targetKey_Ceiling = "X";
		System.out.println("大于或等于键'"+targetKey_Ceiling+"'的最小的键为："+bst.ceiling(targetKey_Ceiling));
		
		int k = 10;
		System.out.println("排名为"+k+"的键为："+bst.select(k));
		
		String targetKey_Rank = "S";
		System.out.println("键"+targetKey_Rank+"的排名是："+bst.rank(targetKey_Rank));
	}
}
