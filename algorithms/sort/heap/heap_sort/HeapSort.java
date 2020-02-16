package algorithms.sort.heap.heap_sort;

import algorithms.sort.SortUtil;
/*
 *	2019-10-22
 *	堆排序算法：基于二叉堆的优先队列实现
 */
public class HeapSort {
	
	public static void main(String[] args) {
		Integer[] array = SortUtil.generateIntegerArray(50, 100);
		System.out.println("原随机数组如下：");
		SortUtil.print(array);
		
		int len = array.length;
		Integer[] pq = new Integer[len+1];
		for (int i=0; i<len; i++) {
			pq[i+1] = array[i];
		}
		
		sort(pq);
		System.out.println("堆排序后的结果如下：");
		print(pq);
	}
	
	private HeapSort() {};

	private static void sort(Integer[] pq) {
		int N = pq.length; // 最后一个结点"指针"
		// 堆构造：实现堆有序
		for (int k = N/2; k>=1; k--) { // 跳过叶子结点
			sink(pq, k, N);
		}
		// 下沉排序：实现堆排序
		while (N>1) {
			exch(pq, 1, N--);
			sink(pq, 1, N);
		}
	}
	
	private static void sink(Integer[] pq, int k, int N) {
		while (2*k<=N) {
			int j = 2*k; // 结点k的左孩子结点
			if (j<N && less(pq, j, j+1)) { // 若结点k有两个结点，且左孩子结点小于右孩子结点
				j++;
			}
			exch(pq, k, j);
			k = j;
		}
	}
	
	private static boolean less(Integer[] pq, int i, int j) {
		return pq[i].compareTo(pq[j])<0;
	}
	
	private static void exch(Integer[] pq, int i, int j) {
		Integer temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private static void print(Integer[] pq) {
		int len = pq.length;
		int count = 0;
		for (int i=1;i<len;i++) {
			System.out.print(pq[i]+" ");
			count++;
			if (count % 10 == 0) {
				System.out.println();
			}
		}
	}
}
