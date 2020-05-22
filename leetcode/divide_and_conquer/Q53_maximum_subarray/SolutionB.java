package leetcode.divide_and_conquer.Q53_maximum_subarray;
/**
 * @author Merlin
 * @date
 */
public class SolutionB {
	/*
	 * 动态规划方法求解
	 * 如何确定状态转移方程？
	 *1.设dp[i]为索引i处的最大子序和
	 *2.dp[i] = max((dp[i-1]+nums[i]),nums[i])
	 */
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length]; // dp数组存储nums数组每个元素位置的当前最大子序和
		dp[0] = nums[0]; // 边界条件
		for(int i=1; i<nums.length; i++) {
			dp[i] = Math.max((dp[i-1]+nums[i]), nums[i]); // 状态转移方程
		}
		
		int res = dp[0];
		for(int i=1; i<dp.length; ++i) {
			res = Math.max(dp[i], res);
		}
		return res;
	}
}
