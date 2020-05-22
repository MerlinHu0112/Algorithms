package algorithms.sort;

import algorithms.sort.bubble.BubbleSort;
import algorithms.sort.heap.heap_sort.HeapSort;
import algorithms.sort.insert.InsertionSort;
import algorithms.sort.insert.InsertionSortOptimization;
import algorithms.sort.merge.QuickMergeSort;
import algorithms.sort.merge.TopDownMergeSort;
import algorithms.sort.merge.optimization.MergeOptimizationA;
import algorithms.sort.merge.optimization.MergeOptimizationB;
import algorithms.sort.quick.QuickSort;
import algorithms.sort.quick.optimization.QuickSortThreeSamplingOptimization;
import algorithms.sort.quick.optimization.QuickSortToInsertionOptimization;
import algorithms.sort.selection.SelectionSort;
import algorithms.sort.shell.ShellSort;
/*
 *	测试单元：独立测试排序算法的正确性
 */
@SuppressWarnings("all")
public class TestSortUnit {
	
	public static void main(String[] args) {
		Integer[] array = SortUtil.generateIntegerArray(50, 100);
		// 实例化相应的类
		//SortMethod sortMethod = new SelectionSort();
		//SortMethod sortMethod = new InsertionSort();
		//SortMethod sortMethod = new InsertionSortOptimization();
		//SortMethod sortMethod = new BubbleSort();
		SortMethod sortMethod = new ShellSort();
		//SortMethod sortMethod = new TopDownMergeSort();
		//SortMethod sortMethod = new QuickMergeSort();
		//SortMethod sortMethod = new MergeOptimizationA();
		//SortMethod sortMethod = new MergeOptimizationB();
		//SortMethod sortMethod = new QuickSort();
		//SortMethod sortMethod = new QuickSortToInsertionOptimization();
		//SortMethod sortMethod = new QuickSortThreeSamplingOptimization();
		
		// 调用
		sortAndPrint(sortMethod, array);
	}
	
	private static void sortAndPrint(SortMethod sortMethod, Integer[] array) {
		System.out.println("原随机数组如下：");
		SortUtil.print(array);
		System.out.println("----------------------");
		sortMethod.sort(array);
		if (SortUtil.isSorted(array)) {
			String className = sortMethod.getClass().getSimpleName();
			switch (className) {
			case "SelectionSort":
				System.out.print("选择排序");
				break;
			case "InsertionSort":
				System.out.print("插入排序");
				break;
			case "InsertionSortOptimization":
				System.out.print("优化后的插入排序");
				break;
			case "BubbleSort":
				System.out.print("冒泡排序");
				break;
			case "ShellSort":
				System.out.print("希尔排序");
				break;
			case "TopDownMergeSort":
				System.out.print("自顶向下的归并排序");
				break;
			case "QuickMergeSort":
				System.out.print("基于自顶向下的快速归并排序");
				break;
			case "MergeOptimizationA":
				System.out.println("归并排序算法的优化之一：对小规模子数组使用插入排序或其它在小规模");
				System.out.print("排序");
				break;
			case "MergeOptimizationB":
				System.out.println("归并排序算法的优化之二：判断数组是否有序");
				System.out.print("排序");
				break;
			case "QuickSort":
				System.out.print("快速排序");
				break;
			case "QuickSortToInsertionOptimization":
				System.out.println("快速排序优化之一：对小规模数组换用插入排序");
				System.out.print("排序");
				break;
			case "QuickSortThreeSamplingOptimization":
				System.out.println("快速排序优化之二：三取样切分");
				System.out.print("排序");
				break;
			default:
				break;
			}
			System.out.println("后的结果如下：");
			SortUtil.print(array);
		}else {
			System.out.println("排序结果存在异常！");
		}
	}
}
