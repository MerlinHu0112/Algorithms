package leetcode.sort;
import org.junit.Test;
/*
 *	2019-11-12
 *	# 1122.数组的相对排序
 *	解题思路：基于桶排序中的计数排序
 */

public class RelativeSortArray {
	
	@Test
	public void testFunction() {
		int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
		int[] arr2 = {2, 1, 4, 3, 9, 6};
		int[] relativeSortArray = relativeSortArray(arr1, arr2);
		for(int i=0;i<relativeSortArray.length;i++) {
			System.out.print(relativeSortArray[i]+" ");
		}
	}
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		
		int[] bucketArray = new int[1001]; // 题目给定了数组最大为1000，故设定1001个桶
		
		// 将arr1数组存入bucketArray中
		for(int i=0;i<arr1.length;i++) {
			bucketArray[arr1[i]]++; 
		}
		
		// 将arr2中出现的元素先行按序存入arr1数组中
		int count = 0;
		for(int i=0;i<arr2.length;i++) {
			int tmp = arr2[i];
			while(bucketArray[tmp]!=0) {
				arr1[count++] = tmp;
				bucketArray[tmp]--;
			}
		}
		
		// 遍历bucketArray，将剩余的元素按升序存入arr1数组中
		for(int i=0;i<1001;i++) {
			while(bucketArray[i]!=0) {
				arr1[count++] = i;
				bucketArray[i]--;
			}
		}
		
		return arr1;
	}
}
