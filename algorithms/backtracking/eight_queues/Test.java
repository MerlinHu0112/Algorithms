package algorithms.backtracking.eight_queues;

public class Test {
	public static void main(String[] args) {
		EightQueens obj = new EightQueens();
		obj.run();
		System.out.println("八皇后问题共有 "+obj.getTotal()+" 种解法");
	}
}
