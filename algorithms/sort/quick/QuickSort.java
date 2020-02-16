package algorithms.sort.quick;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-10-03
 *	快速排序(Quick Sort)算法，递归
 */
public class QuickSort implements SortMethod {

	public void sort(Integer[] array) {
		/*
		 *	2.3.1.2：将数组最大元素置于最右端
		 */
		int maxIndex = SortUtil.findMaxIndex(array);
		SortUtil.exch(array, maxIndex, array.length-1);
		sort(array, 0, array.length-1);
	}
	
	private static void sort(Integer[] array, int lo, int hi) {
		if (lo>=hi) {
			return;
		}
		
		int j = Partition.partition(array, lo, hi); // 切分数组
		sort(array, lo, j-1);
		sort(array, j+1, hi);
	}
	
}
