package algorithms.sort.quick.optimization;

import org.junit.Test;

import algorithms.sort.SortCompareImpl;
import algorithms.sort.SortUtil;
import algorithms.sort.quick.QuickSort;
/*
 *	2019-10-05
 *	实验比较快速排序算法与优化后的快速排序算法的性能差异
 */
public class CompareOptimization extends SortCompareImpl {

	@Test
	public void compare() {
		Integer[] quickArray = SortUtil.generateIntegerArray(1000000, 20);
		Integer[] optimizationArray = SortUtil.copyArray(quickArray);
		CompareOptimization sortCompare = new CompareOptimization();
		sortCompare.sortCompare(quickArray, optimizationArray);
	}
	
	/*---------------------------------------------------------------*/
	/*
	 * 	快速排序优化之一：对小规模数组换用插入排序
	 *	实验结果表明，对于大规模(100万个元素)、由取值范围为[0,100)的随机整数组成的数组
	 *	对小规模数组该用插入排序，性能提高
	 */
	/*
	private void sortCompare(Integer[] quickArray, Integer[] optimizationArray) {
		// 快速排序
		System.out.print("快速排序：");
		if (!SortUtil.isSorted(quickArray)) {
			calculateSortMethodRunTime(new QuickSort(), quickArray);
		}
		// 优化后的快速排序
		System.out.print("优化后的快速排序：");
		if (!SortUtil.isSorted(optimizationArray)) {
			calculateSortMethodRunTime(new QuickSortToInsertionOptimization(), optimizationArray);
		}
	}
	*/
	
	/*---------------------------------------------------------------*/
	/*
	 * 	快速排序优化之二：三取样切分
	 *	实验结果表明，对于大规模(100万个元素)、由取值范围为[0,100)的随机整数组成的数组
	 *	三取样切分使得算法性能不一定提高，视数组所定
	 */
	/*
	private void sortCompare(Integer[] quickArray, Integer[] optimizationArray) {
		// 快速排序
		System.out.print("快速排序：");
		if (!SortUtil.isSorted(quickArray)) {
			calculateSortMethodRunTime(new QuickSort(), quickArray);
		}
		// 优化后的快速排序
		System.out.print("优化后的快速排序：");
		if (!SortUtil.isSorted(optimizationArray)) {
			calculateSortMethodRunTime(new QuickSortThreeSamplingOptimization(), optimizationArray);
		}
	}
	*/
	
	/*---------------------------------------------------------------*/
	/*
	 *	三向切分的快速排序(Dijkstra解法)：针对含有大量重复元素的数组，避免重复元素排序，提高性能
	 *	实验结果表明，针对100万个由[0,20)组成的随机整数数组，三向切分的快速排序明显快于快速排序；但若数组重复元素减少，如
	 *	针对100万个由[0,100000)组成的随机整数数组，三向切分的快速排序性能反而较差。
	 *
	 */
	private void sortCompare(Integer[] quickArray, Integer[] optimizationArray) {
		// 快速排序
		System.out.print("快速排序：");
		if (!SortUtil.isSorted(quickArray)) {
			calculateSortMethodRunTime(new QuickSort(), quickArray);
		}
		// 三向切分快速排序
		System.out.print("三向切分快速排序：");
		if (!SortUtil.isSorted(optimizationArray)) {
			calculateSortMethodRunTime(new ThreeWaySplit(), optimizationArray);
		}
	}
}
