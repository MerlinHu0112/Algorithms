package algorithms.sort.merge.optimization;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-10-03
 *	归并排序算法的优化之三：取消merge()方法中复制辅助数组aux的操作
 *	实现：在递归调用的每个层次互换输入数组和辅助数组
 *	(未完成！暂时搁置)
 */
public class MergeOptimizationC implements SortMethod {
	
	public void sort(Integer[] array) {
		int len = array.length;
		Integer[] aux = new Integer[len];
		for (int i=0;i<len;i++) {
			aux[i] = array[i]; // 仅在此拷贝一次数组至辅助数组
		}
		sort(array, aux, 0, len-1);
	}
	
	private static void sort(Integer[] array, Integer[] aux, int lo, int hi) {
		if(lo>=hi) {
			return;
		}
		int mid = lo + (hi-lo)/2;
		// 在递归调用的每个层次互换输入数组和辅助数组
		sort(aux, array, lo, mid);
		sort(aux, array, mid+1, hi);
		merge(aux,array,lo,mid,hi);
	}
	
	private static void merge(Integer[] array, Integer[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		
		/* 删除复制辅助数组aux的操作，以优化性能
		for (int k=lo; k<=hi; k++) {
			aux[k] = array[k];
		}
		*/
		
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
