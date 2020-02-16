package algorithms.sort.insert;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-09-23
 *	插入排序（Insertion Sort）算法
 *	核心：将a[i]与a[i-1]至a[0]中的每个元素依次比较、交换
 */
public class InsertionSort implements SortMethod {

	// 插入排序算法
	public void sort(Integer[] array) {
		int len = array.length;
		for (int i=1;i<len;i++) {
			// 将a[i]与a[i-1]至a[0]中的每个元素依次比较、交换
			for (int j=i;j>0 && SortUtil.less(array[j], array[j-1]);j--) {
				SortUtil.exch(array, j, j-1);
			}
		}
	}
	
}
