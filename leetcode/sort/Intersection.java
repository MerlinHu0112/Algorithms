package leetcode.sort;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
/*
 *	2019-11-12
 *	# 349.两个数组的交集
 *	解题思路：设置两个set，遍历第一个数组，将值逐一存入set集合中（利用set集合不存储重复值的特性），
 *			 遍历第二个数组，将其元素逐一到set集合中去找，若存在，则存入另一个set中，最后将后一个set
 *			 转换成数组返回。
 */
public class Intersection {

	@Test
	public void testFunction() {
		int[] nums1 = {1, 2, 2, 1, 3, 5, 7, 19};
		int[] nums2 = {2, 2, 19, 8, 8, 5, 5, 5, 6, 6, 7};
		int[] resultArray = intersection(nums1, nums2);
		for(int i=0; i<resultArray.length; i++) {
			System.out.print(resultArray[i]+" ");
		}
	}
	
	/*
	 *	第一次解法
	 */
	/*
	public int[] intersection(int[] nums1, int[] nums2) {
		
		Set<Integer> numsSet = new HashSet<Integer>();
		for(int i=0;i<nums1.length;i++) {
			numsSet.add(nums1[i]);
		}
		
		Set<Integer> resultSet = new HashSet<Integer>();
		for(int i=0;i<nums2.length;i++) {
			if(numsSet.contains(nums2[i])) {
				resultSet.add(nums2[i]);
			}
		}
		
		int[] resultArray = new int[resultSet.size()];
		Iterator<Integer> iterator = resultSet.iterator();
		for(int i=0;i<resultArray.length;i++) {
			if(iterator.hasNext()) {
				resultArray[i] = iterator.next();
			}
		}
		
		return resultArray;
	}
	*/
	
	/*
	 *	第二次，改进：遍历较小的数组
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1.length<=nums2.length) {
			return doIntersection(nums1, nums2);
		}else {
			return doIntersection(nums2, nums1);
		}
	}
	
	private int[] doIntersection(int[] nums1, int[] nums2) {
		// nums1.length <= nums2.length
		
		// 先将长度更长（或相同）的数组nums2存入set集合
		Set<Integer> numsSet = new HashSet<Integer>();
		for(Integer n : nums2) {
			numsSet.add(n);
		}
		
		Set<Integer> resultSet = new HashSet<Integer>();
		for(Integer n : nums1) {
			if(numsSet.contains(n)) {
				resultSet.add(n);
			}
		}
		
		int[] resultArray = new int[resultSet.size()];
		int count = 0;
		for(Integer n : resultSet) {
			resultArray[count++] = n;
		}
		
		return resultArray;
	}
}
