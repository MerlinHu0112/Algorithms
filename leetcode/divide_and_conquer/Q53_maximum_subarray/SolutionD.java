package leetcode.divide_and_conquer.Q53_maximum_subarray;
/**
 * @author Merlin
 * @date
 */
public class SolutionD {
	/*
	 * 分治法求解，思路如下：
	 * 1、将数组沿(left+right)/2划分为两段，分别递归求解两段的最大子序和。
	 * 2、那么，取上述两段最大子序和中的较大者就是数组nums的最大子序和了吗？
	 * 3、显然，2是不成立的。因为：在1的划分中，将数组一分为二，没有考虑到数组跨越中间元素组成的序列的情况。
	 * 4、针对3，如何求跨越中间元素的最大子序和呢？
	 * 5、从中间元素出发，扫描左端求得值A；从中间元素的后一位出发，扫描右端求得值B；二者之和即为跨越中间元素序列的最大子序和
	 * 6、比较左段、右段及跨越中间元素序列的最大子序和，取最大，即为数组nums的最大子序和。
	 */
	public int maxSubArray(int[] nums) {
		return recursion(nums, 0, nums.length-1);
	}
	
	private int recursion(int[] nums, int left, int right) {
		if(left==right) {
			return nums[left];
		}
		
		int mid = (left+right)>>1;
		int leftSum = recursion(nums, left, mid); // 继续划分，递归求解，左段
		int rightSum = recursion(nums, mid+1, right); // 继续划分，递归求解，右段
		int crossSum = crossSum(nums, left, right); // 求解跨越中间元素时的最大序列和
		
		return Math.max(Math.max(leftSum, rightSum), crossSum);
	}
	
	// 求解跨越中间元素时的最大序列和
	private int crossSum(int[] nums, int left, int right) {
		int mid = (left+right)>>1;
		
		int leftCrossSum = Integer.MIN_VALUE;
		int leftCurrSum = 0;
		for(int i=mid; i>=left; i--) {
			// 扫描左边
			leftCurrSum += nums[i];
			leftCrossSum = Math.max(leftCrossSum, leftCurrSum);
		}
		
		int rightCrossSum = Integer.MIN_VALUE;
		int rightCurrSum = 0;
		for(int i=mid+1; i<=right; i++) {
			// 扫描右边
			rightCurrSum += nums[i];
			rightCrossSum = Math.max(rightCrossSum, rightCurrSum);
		}
		
		return leftCrossSum+rightCrossSum;
	}
}
