package algorithms.sort.shell;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-09-29
 *	希尔排序（Shell Sort）算法
 *	希尔排序算法是插入排序算法的一种变种，通过使子序列依次有序实现排序
 *	核心：任意间隔为h的有序数组，增量h减少至1时完成排序
 */
public class ShellSort implements SortMethod {

	// 希尔排序算法
	public void sort(Integer[] array) {
		int len = array.length;
		int h = 1;
		while(h < len/3)
			h = h * 3 + 1; // 设置间隔h的递增序列为1，4，13，40，121，...
		while(h >= 1){
			for(int i = h; i<len; i++){
				int temp = array[i];
				int j = i;
				for(; j >= h && temp < array[j-h]; j-=h)
					array[j] = array[j-h]; // 较大元素向右移动，减少交换次数
				array[j] = temp;
			}
			h /= 3;
		}
	}
	
}

//	int len = array.length;
//	int h = 1;
//		while (h < len/3) {
//		h = 3*h + 1; // 设置间隔h的递增序列为1，4，13，40，121，...
//		}
//		while (h>=1) {
//		for (int i = h;i<len;i++) {
//		for (int j = i;j>=h && SortUtil.less(array[j],array[j-h]);j-=h) {
//		SortUtil.exch(array, j, j-h);
//		}
//		}
//		h = h/3;
//		}