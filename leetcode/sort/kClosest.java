package leetcode.sort;

import java.util.Arrays;

import algorithms.sort.heap.heap_sort.HeapSort;

/*
 *	2019-11-27
 *	# 973. 最接近原点的 K 个点
 *	题目：我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。（这里，平面上两点之间的距离是欧几里德距离。）
 *		  你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
@SuppressWarnings("all")
public class kClosest {
	public int[][] kClosest(int[][] points, int K) {
		int[] distArray = calculateTotalSquares(points);
		int distK = sortAndReturn(distArray, K); // 找到距原点最近的K个点中的临界点
		return findKClosest(points, distK, K);
	}
	
	/*
	 * 	根据距原点最近的K个点中的临界点，逐一比较二维数组所代表的点，符合时
	 * 	存入辅助二维数组kPoints，最后返回该二维数组，即为题意所求
	 */
	private int[][] findKClosest(int[][] points, int distK, int K){
		int[][] kPoints = new int[K][2]; // 存放K个距离原点 (0, 0) 最近的点
		int cnt = 0;
		for(int i=0;i<points.length;i++) {
			if(calculateSquares(points[i])<=distK) {
				kPoints[cnt++] = points[i];
			}
		}
		return kPoints;
	}
	
	// 计算二维数组中所有点距原点距离的平方和，并存入辅助数组
	private int[] calculateTotalSquares(int[][] points) {
		int N = points.length;
		int[] distArray = new int[N];
		for(int i=0;i<N;i++) {
			distArray[i] = calculateSquares(points[i]);
		}
		return distArray;
	}
	
	// 计算二维数组中代表的点距原点距离的平方和
	private int calculateSquares(int[] point) {
		return (int) (Math.pow(point[0], 2)+Math.pow(point[1], 2));
	}
	
	// 对数组distArray进行排序，并返回第k-1位元素
	private int sortAndReturn(int[] distArray, int K) {
		Arrays.sort(distArray);
		return distArray[K-1];
	}
		
}
