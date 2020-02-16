package leetcode.backtracking.permutation;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		SolutionA solution = new SolutionA();
		int[] nums = {1, 2, 3, 4};
		List<List<Integer>> res = solution.permute(nums);
		System.out.println(res.toString());
	}
}
