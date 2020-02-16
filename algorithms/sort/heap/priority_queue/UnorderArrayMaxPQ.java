package algorithms.sort.heap.priority_queue;

/*
 *	2019-10-08
 *	优先队列(Priority Queue)初级实现之一：无序数组(Unorder Array)实现
 *	无序数组实现是指：插入元素时，仅从最右端插入，而不需要考虑在插入时排序
 */
public class UnorderArrayMaxPQ <T extends Comparable<T>> {

	private T[] pq; // 无序数组实现优先队列
	private int length = 0; // 优先队列中的元素个数，初始为0
	private int initLength; // 初始化的优先队列长度
	
	// 构造函数，形参为初始化的优先队列中的元素个数
	@SuppressWarnings("unchecked")
	public UnorderArrayMaxPQ(int initLength) {
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
		pq[length++] = element;
	}
	
	// 返回最大元素
	/*
	 *	这是不好的实现方法，此方法有可能完全打乱优先队列
	public Key max() {
		if (isEmpty()) {
			throw new NoSuchElementException("Priority queue underflow");
		}
		for (int i=0; i<length-1; i++) {
			// 经过循环，最大的元素"冒泡"至数组最右端
			if (less(priorityQueue[i+1], priorityQueue[i])) {
				exch(priorityQueue, i, i+1);
			}
		}
		return priorityQueue[length-1];
	}
	*/
	public T max() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		int maxIndex = 0; // 最大元素指针
		for (int i=1; i<=length-1; i++) {
			if (less(pq[maxIndex], pq[i])) {
				maxIndex = i;
			}
		}
		// exch(maxIndex, length-1); 交换依然会引起个别元素"乱序"，且需要放在删除最大元素的方法中
		return pq[maxIndex];
	}
	
	// 删除并返回最大元素
	public T delMax() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		int maxIndex = 0; // 最大元素指针
		for (int i=1; i<=length-1; i++) {
			if (less(pq[maxIndex], pq[i])) {
				maxIndex = i;
			}
		}
		// 改为最大元素之后至原最右端所有元素向左移动一位，最大元素移至最后一位
		moveMaxElement(maxIndex);
		T maxElement = pq[length-1];
		pq[--length] = null; // clear to let GC do its work
		return maxElement;
	}
	
	private boolean less(T i, T j) {
		return i.compareTo(j)<0;
	}
	
	/*
	private void exch(int i, int j) {
		Key temp = priorityQueue[i];
		priorityQueue[i] = priorityQueue[j];
		priorityQueue[j] = temp;
	}*/
	
	// 实现最大元素之后至原最右端所有元素向左移动一位，最大元素移至最后一位
	private void moveMaxElement(int maxIndex) {
		T temp = pq[maxIndex];
		for (int i = maxIndex; i<length-1; i++) {
			pq[i] = pq[i+1];
		}
		pq[length-1] = temp;
	}
	
	// 遍历
	public void print() {
		for (int i=0;i<length;i++) {
			System.out.print(pq[i]+" ");
		}
		System.out.println();
	}
	
}
