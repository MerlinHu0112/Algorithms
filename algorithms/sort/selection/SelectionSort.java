package algorithms.sort.selection;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-09-23
 *	选择排序（Selection Sort）算法
 *	核心：寻找剩余元素中的最小者
 */
public class SelectionSort implements SortMethod {
	
	// 选择排序算法
	public void sort(Integer[] array) {
		int len = array.length;
		for (int i=0;i<len;i++) {
			int min = i;
			for (int j=i+1;j<len;j++) {
				if (SortUtil.less(array[j], array[min])) {
					min = j;
				}
			}
			SortUtil.exch(array, i, min);
		}
	}
	
}
