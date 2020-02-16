package algorithms.sort.quick.optimization;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-10-05
 *	快速排序优化之二：三取样切分
 */
public class QuickSortThreeSamplingOptimization implements SortMethod {

	public void sort(Integer[] array) {
		SortUtil.exch(array, SortUtil.findMaxIndex(array), array.length-1);
		sort(array, 0, array.length-1);
	}
	
	private static void sort(Integer[] array, int lo, int hi) {
		if (lo>=hi) {
			return;
		}
		int j = partition(array, lo, hi);
		sort(array, lo, j-1);
		sort(array, j+1, hi);
	}
	
	private static int partition(Integer[] array, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		int peIndex = selectPartitionElement(array, lo, hi); // 调用三取样切分方法，返回待切分元素的索引
		SortUtil.exch(array, lo, peIndex);
		Integer partitionElement = array[lo];
		while(true) {
			while(SortUtil.less(array[++i], partitionElement)) {}
			while(SortUtil.less(partitionElement, array[--j])) {}
			if (i>=j) {
				break;
			}
			SortUtil.exch(array, i, j);
		}
		SortUtil.exch(array, lo, j);
		return j;
	}
	
	// 三取样切分方法，返回切分元素的索引
	private static int selectPartitionElement(Integer[] array, int lo, int hi) {
		if ((hi-lo+1)>=3) {
			// 取前三个元素组成新数组，通过插入排序为数组排序，取中间元素
			Integer[] indexArray = {lo, lo+1, lo+2};
			for (int i=0;i<2;i++) {
				for(int j=i+1;j>0;j--) {
					if (SortUtil.less(array[indexArray[j]], array[indexArray[j-1]])) {
						SortUtil.exch(indexArray, j, j-1);
					}
				}
			}
			return indexArray[1];
		}
		return lo; // 当待切分数组长度小于3时，默认array[lo]
	}
	
}
