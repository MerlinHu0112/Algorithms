package algorithms.sort;

import org.junit.Test;

import algorithms.sort.bubble.BubbleSort;
import algorithms.sort.insert.InsertionSort;
import algorithms.sort.merge.TopDownMergeSort;
import algorithms.sort.quick.QuickSort;
import algorithms.sort.selection.SelectionSort;
import algorithms.sort.shell.ShellSort;
/*
 *	各种排序算法性能测试
 */
public class AllSortMethodCompare extends SortCompareImpl {
	
	/*
	 *	实验结果表明，对于50000个取值范围在[0,100)的随机整数组成的数组，
	 *	下述三种排序方式性能由高至低的顺序是：
	 *	 插入排序 > 选择排序 > 冒泡排序
	 */
	@Test
	public void lowSpeedSortCompare() {
		Integer[] bubbleArray = SortUtil.generateIntegerArray(50000,100);
		Integer[] selectionArray = SortUtil.copyArray(bubbleArray);
		Integer[] insertionArray = SortUtil.copyArray(bubbleArray);
		AllSortMethodCompare sortCompare = new AllSortMethodCompare();
		// 冒泡排序
		System.out.print("冒泡排序：");
		if (!SortUtil.isSorted(bubbleArray)) {
			sortCompare.calculateSortMethodRunTime(new BubbleSort(), bubbleArray);
		}
		// 选择排序
		System.out.print("选择排序：");
		if (!SortUtil.isSorted(selectionArray)) {
			sortCompare.calculateSortMethodRunTime(new SelectionSort(), selectionArray);
		}
		// 插入排序
		System.out.print("插入排序：");
		if (!SortUtil.isSorted(insertionArray)) {
			sortCompare.calculateSortMethodRunTime(new InsertionSort(), insertionArray);
		}
	}
	
	/*
	 *	实验结果表明，对于更大规模的数组（1000000个取值范围在[0,100)的随机整数组成的数组），
	 *	下述三种排序方式性能由高至低的顺序是：归并排序 (略大于) 快速排序 > 希尔排序 >> 插入排序
	 */
	@Test
	public void highSpeedSortCompare() {
		Integer[] shellArray = SortUtil.generateIntegerArray(1000000,100);
		Integer[] mergeArray = SortUtil.copyArray(shellArray);
		Integer[] quickArray = SortUtil.copyArray(shellArray);
		AllSortMethodCompare sortCompare = new AllSortMethodCompare();
		// 希尔排序
		System.out.print("希尔排序：");
		if (!SortUtil.isSorted(shellArray)) {
			sortCompare.calculateSortMethodRunTime(new ShellSort(), shellArray);
		}
		// 归并排序
		System.out.print("归并排序：");
		if (!SortUtil.isSorted(mergeArray)) {
			sortCompare.calculateSortMethodRunTime(new TopDownMergeSort(), mergeArray);
		}
		// 快速排序
		System.out.print("快速排序：");
		if (!SortUtil.isSorted(quickArray)) {
			sortCompare.calculateSortMethodRunTime(new QuickSort(), quickArray);
		}
	}

}
