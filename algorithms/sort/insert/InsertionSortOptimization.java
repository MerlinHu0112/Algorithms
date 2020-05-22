package algorithms.sort.insert;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-09-29
 *	插入排序算法的优化：在内循环中，较大的元素向右移动，而不是频繁地交换
 *	优点：使得数组访问次数减半，优化算法
 */
public class InsertionSortOptimization implements SortMethod {
	
	// 插入排序算法的优化
	public void sort(Integer[] array) {
		int len = array.length;
		for (int i=1;i<len;i++) {
			int temp = array[i];
			// 在内循环中，较大的元素向右移动
			int j;
			for (j=i;j>0 && SortUtil.less(temp, array[j-1]);j--) {
				array[j] = array[j-1];
			}
			array[j] = temp;
		}
	}
	
}