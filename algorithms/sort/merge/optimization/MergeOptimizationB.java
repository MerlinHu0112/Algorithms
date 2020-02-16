package algorithms.sort.merge.optimization;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
import algorithms.sort.merge.Merge;
/*
*	2019-10-03
*	归并排序算法的优化之二：判断数组是否有序
*	实现：添加 a[mid] <= a[mid+1] 的判断条件
*/
public class MergeOptimizationB implements SortMethod {

	private static Integer[] aux;
	
	public void sort(Integer[] array) {
		aux = new Integer[array.length];
		sort(array, 0, array.length-1);
	}
	
	private static void sort(Integer[] array, int lo, int hi) {
		if (lo>=hi) {
			return;
		}
		
		int mid = lo + (hi-lo)/2;
		sort(array, lo, mid);
		sort(array, mid+1, hi);
		
		if (!SortUtil.less(array[mid+1],array[mid])) {
			// a[mid] <= a[mid+1]，则认为数组是有序的，可跳过merge()方法
			return;
		}
		
		Merge.merge(array, aux, lo, mid, hi);
	}

	
}
