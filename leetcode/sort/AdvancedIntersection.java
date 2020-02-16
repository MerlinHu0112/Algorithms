package leetcode.sort;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 *	2019-11-13
 *	# 350.两个数组的交集进阶版--考虑元素在数组中的重复情况
 *	输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致
 */
@SuppressWarnings("all")
public class AdvancedIntersection {

	@Test
	public void testFunction() {
		int[] nums1 = {1, 2, 2, 1, 3, 5, 7, 19};
		int[] nums2 = {2, 2, 19, 8, 8, 5, 5, 5, 6, 6, 7};
		/*int[] resultArray = intersection(nums1, nums2);
		for(int i=0; i<resultArray.length; i++) {
			System.out.print(resultArray[i]+" ");
		}*/
	}
	
	/*
	 *	第一版未通过LeetCode提交的算法
	 *	总结：使用HashMap保存数组元素和出现次数的思路是正确的，但较优的方式是仅将一个数组转换成Map，
	 *	而遍历另一个数组进行比较。
	 */
	/*
	public int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> nums1_map = transferToMap(nums1);
		Map<Integer, Integer> nums2_map = transferToMap(nums2);
		int[] resultArray = new int[nums1.length+nums2.length];
		int count = 0;
		for(Integer key : nums1_map.keySet()) {
			Integer nums1_cnt = nums1_map.get(key);
			Integer nums2_cnt = nums2_map.get(key);
			if(nums2_cnt!=null) {
				if(nums2_cnt<=nums1_cnt) {
					for(int i=0;i<nums2_cnt;i++) {
						resultArray[count++]=key;
					}
				}
				if(nums1_cnt<nums2_cnt) {
					for(int i=0;i<nums1_cnt;i++) {
						resultArray[count++]=key;
					}
				}
			}
		}
		int[] newResultArray = new int[count];
		for(int i=0;i<count;i++) {
			newResultArray[i]=resultArray[i];
		}
		return newResultArray;
	}
	
	private Map<Integer, Integer> transferToMap(int[] nums){
		Map<Integer, Integer> nums_map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			int cnt = 1;
			int tmp = nums[i];
			if(!nums_map.containsKey(tmp)) {
				nums_map.put(tmp, cnt);
			}else {
				nums_map.replace(tmp, ++cnt);
			}
		}
		return nums_map;
	}
	*/
}
