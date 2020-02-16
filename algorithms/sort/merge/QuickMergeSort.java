package algorithms.sort.merge;

import algorithms.sort.SortMethod;
/*
 *	2019-09-29
 *	提高题 2.2.10：实现快速归并中的merge()方法
 *	基于TopDownMergeSort类，修改其中的merge()方法，实现快速归并排序
 */
public class QuickMergeSort implements SortMethod {

	private static Integer[] aux; // 辅助数组
	
	public void sort(Integer[] array) {
		aux = new Integer[array.length];
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(Integer[] array, int lo, int hi) {
		if (lo>=hi) {
			return;
		}
		
		int mid = lo + (hi-lo)/2;
		quickSort(array, lo, mid);
		quickSort(array, mid+1, hi);
		QuickMerge.merge(array, aux, lo, mid, hi);
	}

	

}
