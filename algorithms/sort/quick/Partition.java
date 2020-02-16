package algorithms.sort.quick;

import algorithms.sort.SortUtil;
/*
 *	2019-10-04
 *	Partition类：实现快速排序算法中划分数组的功能
 *	包括：算法2.5及2.3.1.1-2.3.1.5部分对partition()方法的改进
 */
public class Partition {

	// 通过切分，保证切分位置左侧的所有元素均不大于array[lo]，右侧则是不小于array[lo]。
	public static int partition(Integer[] array, int lo, int hi) {
		int i = lo; // 左指针
		int j = hi+1; // 右指针
		Integer partitionElement = array[lo];
		while(true) {
			// 首先，从数组的左端开始向右扫描，直至找到一个不小于partitionElement的元素
			while(SortUtil.less(array[++i], partitionElement)) {}
			// 随后，从数组的右端开始向左扫描，直至找到一个不大于partitionElement的元素
			while(SortUtil.less(partitionElement, array[--j])) {}
			if(i>=j) {
				break;
			}
			// 若上述循环中分别找出对应的i、j，则交换二者，以保证i指针左侧元素均不大于partitionElement，
			// 而j指针右侧元素均不小于partitionElement
			SortUtil.exch(array, i, j);
		}
		// i、j指针相遇，交换lo和j位置元素
		SortUtil.exch(array, lo, j);
		return j;
	}
	
	/*
	 // 在切分过程中，可指定切分元素为array[lo]；
	// 通过切分，保证切分位置左侧的所有元素均不大于array[lo]，右侧则是不小于array[lo]。
	public static int partition(Integer[] array, int lo, int hi) {
		int i = lo; // 左指针
		int j = hi+1; // 右指针
		Integer partitionElement = array[lo];
		while(true) {
			// 首先，从数组的左端开始向右扫描，直至找到一个不小于partitionElement的元素
			while(SortUtil.less(array[++i], partitionElement)) {
				/* 2.3.1.2：在sort()方法中，将数组最大元素置于最右端，保证i指针不会
				 * 越过右端边界！
				if(i==hi) {
					break; // 若至最右端，终止循环
				}
				*/
		/*	}
			// 随后，从数组的右端开始向左扫描，直至找到一个不大于partitionElement的元素
			while(SortUtil.less(partitionElement, array[--j])) {
				/* 2.3.1.2：切分元素partitionElement充当哨兵，由于array[lo]=partitionElement，
				 * 故j指针不会越过左端边界！
				if(j==lo) {
					break;
				}
				*/
		/*	}
			if(i>=j) {
				break;
			}
			// 若上述循环中分别找出对应的i、j，则交换二者，以保证i指针左侧元素均不大于partitionElement，
			// 而j指针右侧元素均不小于partitionElement
			SortUtil.exch(array, i, j);
		}
		// i、j指针相遇，交换lo和j位置元素
		SortUtil.exch(array, lo, j);
		return j;
		}
	 */
}
