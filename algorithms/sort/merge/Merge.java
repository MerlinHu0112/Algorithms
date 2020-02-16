package algorithms.sort.merge;

import algorithms.sort.SortUtil;
/*
 *	2019-10-03
 *	Merge类，借助辅助数组aux实现两个有序的数组的合并
 */
@SuppressWarnings("all")
public class Merge {

	// 借助辅助数组aux，将两个有序的数组归并成一个大的数组，即归并
	public static void merge(Integer[] array, Integer[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		
		for (int k=lo; k<=hi; k++) {
			aux[k] = array[k]; // 将待归并数组拷贝至辅助数组
		}
		
		for (int k=lo; k<=hi; k++) {
			if (i>mid) {
				array[k] = aux[j++]; // 左半边用尽，取右半边的元素
			}else if (j>hi) {
				array[k] = aux[i++]; // 右半边用尽，取左半边的元素
			}else if (SortUtil.less(aux[j], aux[i])) {
				array[k] = aux[j++]; // 右半边的当前元素小于左半边的当前元素，则取右半边的元素
			}else {
				array[k] = aux[i++]; // 右半边的当前元素大于左半边的当前元素，则取左半边的元素
			}
		}
	}
	
}
