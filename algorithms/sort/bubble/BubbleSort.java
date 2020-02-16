package algorithms.sort.bubble;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-09-26
 *	冒泡排序
 *	核心：比较相邻的元素，大者在前则交换
 */
public class BubbleSort implements SortMethod {
	
	// 冒泡排序算法
	public void sort(Integer[] array) {
		int len = array.length;
		for (int i=1;i<len;i++) {
			for (int j=0;j<len-i;j++) {
				if (SortUtil.less(array[j+1], array[j])) {
					SortUtil.exch(array, j, j+1);
				}
			}
		}
	}
	
}
