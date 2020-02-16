package leetcode.sort;

import java.util.ArrayList;
import java.util.List;
/*
 *	2019-12-01
 *	# 969. 煎饼排序
 *	题目：给定数组A，选择一些正整数 k <= A.length，反转A的前k个元素的顺序。执行零次或多次煎饼翻转以完成对数组A的排序。
 *	要求：翻转次数在 10 * A.length 范围内
 *		 A[i]是[1, 2, ..., A.length]的排列
 *	思路：将两次翻转视为一个循环，每一次循环之后，位于循环区间内的元素，最大的值落到最右边，类似于冒泡排序
 */
public class PancakeSort {

	private List<Integer> target;

	public List<Integer> pancakeSort(int[] A) {
		int flag = A.length-1;
		target = new ArrayList<Integer>();
		while(flag>=1) {
			sort(A, flag);
			flag--;
		}
		return target;
	}
 
	private void sort(int[] A, int range) {
		int maxEleIndex = getMaxElementIndex(A, range);
		traverse(A, maxEleIndex); // 通过反转[1, maxEleIndex]部分，使得maxEleIndex对应的元素被调至索引1处
		target.add(maxEleIndex+1);
		traverse(A, range); // 再反转，使得最大值调至最后一位
		target.add(range+1);
	}
 
	// 反转数组A中[1,index]中的元素
	private void traverse(int[] A, int index) {
		int mid = index/2;
		for(int i=0;i<=mid;i++) {
			exch(A, i, index-i);
		}
	}
	
	// 在索引[1, count]范围寻找最大的元素，并返回相应的索引
	private int getMaxElementIndex(int[] A, int range) {
		int index = 0;
		for(int i=1;i<=range;i++) {
			if(A[index]<A[i]) {
				index = i;
			}
		}
		return index;
	}
 
	private void exch(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
}
