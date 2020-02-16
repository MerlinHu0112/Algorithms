package algorithms.sort.heap.heap_sort;

import java.util.ArrayList;
/*
 *	2019-10-14
 *	基于二叉堆的优先队列实现
 *	使用ArrayList数据结构
 */
public class MaxPQ <T extends Comparable<T>> {

	private ArrayList<T> pq;
	
	// 构造函数
	// 形参placeholder为pq[0]的占位元素
	public MaxPQ(T placeholder) {
		pq = new ArrayList<T>() ;
		pq.add(0, placeholder);
	}
	
	// 返回队列是否为空
	public boolean isEmpty() {
		return size()==0;
	}
	
	// 返回优先队列中的元素个数
	public int size() {
		return pq.size()-1; // 因为pq[0]不存储数据
	}
	
	// 向优先队列中插入一个元素
	public void insert(T element) {
		pq.add(element);
		swim(size()); // 调用"上浮"方法，使二叉堆有序化
	}
	
	// 返回最大元素，即根节点元素，pq[1]
	public T max() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		return pq.get(1);
	}
	
	// 删除并返回最大元素
	public T delMax() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		T maxElement = pq.get(1);
		int N = size(); // 最后一个结点"指针"
		exch(1, N); // 交换根结点与最后一个结点的元素
		pq.remove(N); // 移除最后一个结点
		sink(1); // 调用"下沉"方法，使二叉堆有序化
		return maxElement;
	}
	
	// 由下至上的二叉堆有序化--上浮
	// 某个结点大于它的父结点，则与之交换，直至二叉堆有序
	private void swim(int k) {
		// 若结点k不为根结点，且其父结点2k小于该结点
		while (k>1 && less(k/2, k)) {
			exch(k/2, k);
			k=k/2;
		}
	}
	
	// 由下至上的二叉堆有序化--下沉
	// 只要存在某结点小于其子结点，则将父结点与子结点中的较大者交换，直至二叉堆有序
	private void sink(int k) {
		int N = size(); // 最后一个结点"指针"
		while (2*k<=N) {
			int j = 2*k; // 结点k的左孩子结点
			if (j<N && less(j, j+1)) {
				j++; // 若结点k有两个结点，且左孩子结点小于右孩子结点
			}
			exch(k, j);
			k = j;
		}
	}
	
	private boolean less(int i, int j) {
		return pq.get(i).compareTo(pq.get(j))<0;
	}
	
	private void exch(int i, int j) {
		T temp = pq.get(i);
		pq.set(i, pq.get(j));
		pq.set(j, temp);
	}
	
	// 遍历
	public void print() {
		for (int i=1; i<=size();i++) {
			System.out.print(pq.get(i)+" ");
		}
		System.out.println();
	}
	
}
