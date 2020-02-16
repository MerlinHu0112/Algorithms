package algorithms.sort.merge.optimization;

import algorithms.sort.OptimizationUtil;
import algorithms.sort.SortMethod;
import algorithms.sort.merge.Merge;
/*
 *	2019-10-03
 *	归并排序算法的优化之一：对小规模子数组使用插入排序或其它在小规模数组条件下优于递归算法的算法。
 */
public class MergeOptimizationA implements SortMethod {
	
	private static Integer[] aux;
	private static final int subArrayLengthFlag = 16; // 递归中，子数组长度小于或等于subArrayLengthFlag时，使用插入排序
	
	public void sort(Integer[] array) {
		aux = new Integer[array.length];
		sort(array, 0, array.length-1);
	}
	
	private static void sort(Integer[] array, int lo, int hi) {
		if (lo>=hi) {
			return;
		}
		
		if ((hi-lo+1)<=subArrayLengthFlag) {
			// 递归进行中，当子数组规模小于或等于subArrayLengthFlag时，使用插入排序
			OptimizationUtil.insertionSort(array,lo,hi);
			return;
		}
		int mid = lo + (hi-lo)/2;
		sort(array, lo, mid);
		sort(array, mid+1, hi);
		Merge.merge(array, aux, lo, mid, hi);
	}
	
}
