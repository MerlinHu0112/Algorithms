package algorithms.sort.merge;

import algorithms.sort.SortUtil;
/*
 *	2019-10-03
 *	提高题 2.2.10：实现快速归并中的merge()方法
 */
public class QuickMerge {
	
	// 快速归并
	public static void merge(Integer[] array, Integer[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = hi;
		
		for (int k=lo; k<=mid; k++) {
			aux[k] = array[k]; // 将数组array的前半部分按原拷贝至辅助数组
		}
		
		for (int k=mid+1; k<=hi; k++) {
			// 将数组array的后半部分按照降序（此前已为
			// 顺序排序）复制至辅助数组aux
			aux[k] = array[hi-k+mid+1]; 
		}
		
		// 快速归并中，不需要再判断左右半边是否用尽
		for (int k=lo; k<=hi; k++) {
			if (SortUtil.less(aux[j], aux[i])) {
				array[k] = aux[j--]; // 右半边的当前元素小于左半边的当前元素，则取右半边的元素
			}else {
				array[k] = aux[i++]; // 右半边的当前元素大于左半边的当前元素，则取左半边的元素
			}
		}
	}
	
}
