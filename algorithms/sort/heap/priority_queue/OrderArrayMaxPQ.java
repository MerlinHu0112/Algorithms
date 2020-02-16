package algorithms.sort.heap.priority_queue;

/*
 *	2019-10-09
 *	优先队列(Priority Queue)初级实现之二：有序数组(Order Array)实现
 *	有序数组实现是指：插入元素时就排序，最大元素始终在最右端
 */
public class OrderArrayMaxPQ <T extends Comparable<T>> {
	
	private T[] pq; // 有序数组实现优先队列
	private int length = 0; // 优先队列中的元素个数，初始为0
	private int initLength; // 初始化的优先队列长度
	
	// 构造函数，形参为初始化的优先队列中的元素个数
	@SuppressWarnings("unchecked")
	public OrderArrayMaxPQ(int initLength) {
		pq = (T[]) new Comparable[initLength];
		this.initLength = initLength;
	}
	
	
	// 返回队列是否为空
	public boolean isEmpty() {
		return length==0;
	}
	
	// 返回优先队列中的元素个数
	public int size() {
		return length;
	}
	
	// 向优先队列中插入一个元素
	public void insert(T element) {
		if (length==initLength) {
			throw new RuntimeException("The length of priority queue is larger than initlength");
		}
		if (length==0) {
			// 第一个元素直接插入
			pq[length] = element;
		}else {
			int i;
			for (i=length-1; i>=0 && less(element, pq[i]); i--) {
				pq[i+1] = pq[i]; // 较大的值向右移动一位
			}
			pq[i+1] = element; // 按序插入新值
		}
		length++;
	}
	
	// 返回最大元素
	public T max() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		return pq[length-1]; // 最右端即为最大值
	}
	
	// 删除并返回最大元素
	public T delMax() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		T maxElement = pq[length-1];
		pq[--length] = null;
		return maxElement; // clear to let GC do its work
	}
	
	private boolean less(T i, T j) {
		return i.compareTo(j)<0;
	}
	
	// 遍历
	public void print() {
		for (int i=0;i<length;i++) {
			System.out.print(pq[i]+" ");
		}
		System.out.println();
	}
	
}
