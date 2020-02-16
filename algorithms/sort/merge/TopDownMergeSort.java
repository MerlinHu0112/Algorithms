package algorithms.sort.merge;

import algorithms.sort.SortMethod;
/*
 *	2019-09-29
 *	Chapter 2.2.2：（自顶向下）的归并排序(Merge Sort)算法，递归算法
 */
public class TopDownMergeSort implements SortMethod {
	
	private static Integer[] aux; // 辅助数组
	
	public void sort(Integer[] array) {
		aux = new Integer[array.length]; // 为辅助数组分配空间
		sort(array, 0, array.length-1);
	}
	
	// 将数组array[lo,hi]排序
	private static void sort(Integer[] array, int lo, int hi) {
		if (lo>=hi) {
			return;
		}
		
		int mid = lo + (hi-lo)/2;
		sort(array, lo, mid); // 递归调用sort，先将左半部分归并排序
		sort(array, mid+1, hi); // 再将右半部分归并排序
		Merge.merge(array, aux, lo, mid, hi);
	}
	
}
