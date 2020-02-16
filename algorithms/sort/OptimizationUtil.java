package algorithms.sort;

/*
 *	2019-10-05
 *	排序算法优化时使用到的工具类，目前仅包括对小数组改用插入排序的方法
 */
@SuppressWarnings("all")
public class OptimizationUtil {

	// 对于其它排序算法(如归并、快速排序)，递归过程中数组规模逐渐减小。
	// 当数组规模小于一定时，换用插入排序可提高算法性能
	public static void insertionSort(Integer[] array, int lo, int hi) {
		for (int i=lo+1;i<=hi;i++) {
			for (int j=i;j>lo && SortUtil.less(array[j], array[j-1]);j--) {
				SortUtil.exch(array, j, j-1);
			}
		}
	}
	
}
