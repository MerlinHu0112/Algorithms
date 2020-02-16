package algorithms.sort.quick.optimization;

import algorithms.sort.SortMethod;
import algorithms.sort.SortUtil;
/*
 *	2019-10-07
 *	三向切分的快速排序(Dijkstra解法)：针对含有大量重复元素的数组，避免重复元素排序，提高性能
 */
public class ThreeWaySplit implements SortMethod {

	public void sort(Integer[] array) {
		sort(array, 0, array.length-1);
	}

	// 三向切分的核心算法
	private static void sort(Integer[] array, int lo, int hi) {
		if (lo>=hi) {
			return;
		}
		int lt = lo; // lt指针：array[lo,lt-1]所有元素均小于切分元素partitionElement
		int gt = hi; // gt指针：array[gt+1,hi]所有元素均大于切分元素
		int i = lo+1;
		Integer partitionElement = array[lo];
		// while循环执行完毕，array[lo,lt-1]所有元素均小于切分元素，而
		// array[gt+1,hi]所有元素均大于切分元素，且array[lt,gt]所有元
		// 素均等于切分元素，所以array[lt,gt]数组不再需要排序
		while(i<=gt) {
			int flag = array[i].compareTo(partitionElement);
			if (flag>0) {
				SortUtil.exch(array, i, gt--);
			}else if (flag<0) {
				SortUtil.exch(array, i++, lt++);
			}else {
				i++;
			}
		}
		sort(array, lo, lt-1);
		sort(array, gt+1, hi);
	}
}
