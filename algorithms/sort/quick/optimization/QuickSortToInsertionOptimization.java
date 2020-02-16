package algorithms.sort.quick.optimization;

import algorithms.sort.OptimizationUtil;
import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
import algorithms.sort.quick.Partition;
/*
 *	2019-10-05
 *	快速排序优化之一：对小规模数组换用插入排序
 */
public class QuickSortToInsertionOptimization implements SortMethod {
	
	private static final int subArrayLengthFlag = 15;
	
	public void sort(Integer[] array) {
		int maxIndex = SortUtil.findMaxIndex(array);
		SortUtil.exch(array, maxIndex, array.length-1);
		sort(array, 0, array.length-1);
	}
	
	private static void sort(Integer[] array, int lo, int hi) {
		if ((hi-lo+1)<=subArrayLengthFlag) {
			OptimizationUtil.insertionSort(array, lo, hi); // 对小规模数组换用插入排序
			return;
		}
		
		int j = Partition.partition(array, lo, hi); // 切分数组
		sort(array, lo, j-1);
		sort(array, j+1, hi);
	}
	
}
