package algorithms.sort.merge;

import org.junit.Test;

import algorithms.sort.SortCompareImpl;
import algorithms.sort.SortUtil;
/*
 *	2019-10-03
 *	基于TopDownMergeSort类和QuickMergeSort类
 *	比较归并算法与快速归并算法处理大规模随机数组时的性能
 */
public class CompareMergeAndQuickMerge extends SortCompareImpl {
	
	/*
	 *	实验结果表明，对于大规模由取值范围为[0,100)的随机整数组成的数组，
	 *	快速归并排序性能接近原归并排序，数组规模足够大时，快速归并要稍好。
	 */
	@Test
	public void compare() {
		Integer[] mergeArray = SortUtil.generateIntegerArray(2000000,100);
		Integer[] quickMergeArray = SortUtil.copyArray(mergeArray);
		CompareMergeAndQuickMerge sortCompare = new CompareMergeAndQuickMerge();
		sortCompare.sortCompare(mergeArray, quickMergeArray);
	}

	private void sortCompare(Integer[] mergeArray, Integer[] quickMergeArray) {
		// 自顶向下的归并排序
		System.out.print("自顶向下的归并排序：");
		if (!SortUtil.isSorted(mergeArray)) {
			calculateSortMethodRunTime(new TopDownMergeSort(), mergeArray);
		}
		// 快速归并排序
		System.out.print("快速归并排序：");
		if (!SortUtil.isSorted(quickMergeArray)) {
			calculateSortMethodRunTime(new QuickMergeSort(), quickMergeArray);
		}
	}
	
}
