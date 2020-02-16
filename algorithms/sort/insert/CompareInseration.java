package algorithms.sort.insert;

import org.junit.Test;

import algorithms.sort.SortCompareImpl;
import algorithms.sort.SortUtil;
/*
 * 插入排序算法和优化后的插入排序算法性能比较
 */
public class CompareInseration extends SortCompareImpl {
	
	/*
	 *	实验结果表明，对于大规模由取值范围为[0,100)的随机整数组成的数组，
	 *	优化后的插入排序性能较优
	 */
	@Test
	public void compare() {
		Integer[] insertionArray = SortUtil.generateIntegerArray(50000,100);
		Integer[] isoArray = SortUtil.copyArray(insertionArray);
		CompareInseration compareInseration = new CompareInseration();
		compareInseration.sortCompare(insertionArray, isoArray);
	}
	
	private void sortCompare(Integer[] insertionArray, Integer[] isoArray) {
		// 插入排序
		System.out.print("插入排序：");
		if (!SortUtil.isSorted(insertionArray)) {
			calculateSortMethodRunTime(new InsertionSort(), insertionArray);
		}
		// 优化后的插入排序
		System.out.print("优化后的插入排序：");
		if (!SortUtil.isSorted(isoArray)) {
			calculateSortMethodRunTime(new InsertionSortOptimization(), isoArray);
		}
	}

}
