package leetcode.double_pointers;

/**
 * @date 2019-12-15
 * @author Merlin
 * 题目：给定一个已排序数组，原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		/*
		 *	最先考虑到的方法复杂且有bug，参考题解暗示，采用双指针
		 *	当i、j索引元素相等时，j++，直至i、j索引元素不同，此时
		 *	用j索引元素覆盖i+1索引元素
		 */
		if(nums==null || nums.length==0) {
			return 0;
		}
		
		int i = 0, j = 1;
		while(j<nums.length) {
			if(nums[j]!=nums[i]) {
				nums[i++] = nums[j];
			}
			j++;
		}
		
		return i+1;
    }
}
