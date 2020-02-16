package algorithms.sort.bubble;

import algorithms.sort.SortCompareImpl;
import algorithms.sort.SortUtil;
import algorithms.sort.insert.InsertionSort;
/*
 *	比较插入排序算法和冒泡排序算法运行时间
 */
public class CompareInsertionAndBubble extends SortCompareImpl {
	
	public static void main(String[] args) {
		Integer[] insertionArray = SortUtil.generateIntegerArray(50000,100);
		Integer[] bubbleArray = SortUtil.copyArray(insertionArray);
		CompareInsertionAndBubble sortCompare = new CompareInsertionAndBubble();
		sortCompare.sortCompare(insertionArray, bubbleArray);
	}
	
	private void sortCompare(Integer[] insertionArray, Integer[] bubbleArray) {
		// 插入排序
		System.out.print("插入排序：");
		if (!SortUtil.isSorted(insertionArray)) {
			calculateSortMethodRunTime(new InsertionSort(), insertionArray);
		}
		// 冒泡排序
		System.out.print("冒泡排序：");
		if (!SortUtil.isSorted(bubbleArray)) {
			calculateSortMethodRunTime(new BubbleSort(), bubbleArray);
		}
	}
	
}
