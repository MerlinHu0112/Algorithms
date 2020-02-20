package leetcode.array.rotate_k;
/**
 * LeetCode 189.旋转数组
 * Q：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @date 2020-02-20
 * @author Merlin
 */
public class SolutionA {
	/*
	 *	第一次提交的暴力解法，时间复杂度为O(k*n)，超时；
	 *	第二次提交的算法，时间复杂度优化为O(n)，但针对特殊的k、n值出现输出异常
	 *	结合官方题解，现总结如下：若 n % k == 0，则一定会导致在尚未遍历完数组的
	 *	情况下再次回到出发点，这也是第二次提交的算法针对特定的k、n值会报错的原因。
	 *	结合官方题解给出的"环状替换法"修正算法  
	 */
	public void rotate(int[] nums, int k) {
		k = k % nums.length; // k，k+(nums.length)，k+(2*nums.length) 等，移动效果等同于k
		int count = 0; // 统计元素移动次数
		
		// start：起始位，当未遍历完再次回到出发点时，执行start++，人为地改变起始位
		for(int start=0; count<nums.length; start++) {
			int p = start; // 当前待移动元素的索引
			int pVal = nums[p]; // 当前待移动的元素值
			// 从起始位开始正常执行替换；若在执行过程中再次回到出发点start位，将其加1
			do {
				p = (p + k) % (nums.length);
				int temp = nums[p];
				nums[p] = pVal;
				pVal = temp;
				count++;
			}while(p!=start);
		}
	}
}
