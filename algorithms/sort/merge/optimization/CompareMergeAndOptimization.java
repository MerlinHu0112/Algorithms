package algorithms.sort.merge.optimization;

import org.junit.Test;

import algorithms.sort.SortCompareImpl;
import algorithms.sort.SortUtil;
import algorithms.sort.merge.TopDownMergeSort;
/*
 *	2019-10-04
 *	实验比较归并排序与优化后的归并排序性能
 *	存在的问题：优化后算法可正确执行，但性能并未提升，暂时未知具体原因！！！
 */
public class CompareMergeAndOptimization extends SortCompareImpl {

	/*
	 *	实验结果表明，对于大规模由取值范围为[0,100)的随机整数组成的数组，
	 *	原归并排序的性能要优于优化后的归并排序！！！(这与预想不符，暂未找出原因)
	 */
	@Test
	public void compare() {
		Integer[] mergeArray = SortUtil.generateIntegerArray(500000,100);
		Integer[] optimizationArray = SortUtil.copyArray(mergeArray);
		CompareMergeAndOptimization sortCompare = new CompareMergeAndOptimization();
		sortCompare.sortCompare(mergeArray, optimizationArray);
	}
	
	/*------------------------------------------------------------*/
	/*
	 *	归并排序算法的优化之一：对小规模子数组使用插入排序
	 *	实验结果表明，对于大规模由取值范围为[0,100)的随机整数组成的数组，
	 *	优化后的算法性能反而更差！原因未知！
	 */
	private void sortCompare(Integer[] mergeArray, Integer[] optimizationArray) {
		// 自顶向下的归并排序
		System.out.print("自顶向下的归并排序：");
		if (!SortUtil.isSorted(mergeArray)) {
			calculateSortMethodRunTime(new TopDownMergeSort(), mergeArray);
		}
		// 优化后的归并排序
		System.out.print("优化后的归并排序：");
		if (!SortUtil.isSorted(optimizationArray)) {
			calculateSortMethodRunTime(new MergeOptimizationA(), optimizationArray);
		}
	}

	/*------------------------------------------------------------*/
	/*
	 *	归并排序算法的优化之二：判断数组是否有序
	 *	实验结果表明，对于大规模由取值范围为[0,100)的随机整数组成的数组，
	 *	归并排序算法优化(第二种方法)后的性能要稍好于原归并算法
	 */
	/*
	private void sortCompare(Integer[] mergeArray, Integer[] optimizationArray) {
		// 自顶向下的归并排序
		System.out.print("自顶向下的归并排序：");
		if (!SortUtil.isSorted(mergeArray)) {
			calculateSortMethodRunTime(new TopDownMergeSort(), mergeArray);
		}
		// 优化后的归并排序
		System.out.print("优化后的归并排序：");
		if (!SortUtil.isSorted(optimizationArray)) {
			calculateSortMethodRunTime(new MergeOptimizationB(), optimizationArray);
		}
	}
	*/
}
