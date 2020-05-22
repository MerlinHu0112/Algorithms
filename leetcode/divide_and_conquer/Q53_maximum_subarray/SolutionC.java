package leetcode.divide_and_conquer.Q53_maximum_subarray;
/**
 * @author Merlin
 * @date 2020-02-25
 */
public class SolutionC {
	
	// 基于SolutionB的DP算法进行优化 -- 此算法也叫 Kadane算法
	// 使用currSum记录当前位置的最大子序和，maxSum记录
	// 当前最大的currSum，以替代dp数组。
	public int maxSubArray(int[] nums) {
		
		int currSum = nums[0];
		int maxSum = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			currSum = Math.max((currSum+nums[i]), nums[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}
}
