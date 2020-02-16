package algorithms.sort.heap.priority_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/*
 *	2019-10-10
 *	优先队列(Priority Queue)初级实现之三：无序链表(Unorder LinkedList)实现
 */
@SuppressWarnings("all")
public class UnorderLinkedListMaxPQ <T extends Comparable<T>> {
	
	private LinkedList<T> pq;
	
	// 构造函数
	public UnorderLinkedListMaxPQ() {
		pq = new LinkedList<T>();
	}

	// 返回队列是否为空
	public boolean isEmpty() {
		return size()==0;
	}
	
	// 返回优先队列中的元素个数
	public int size() {
		return pq.size();
	}
	
	// 向优先队列中插入一个元素
	public void insert(T element) {
		pq.add(element);
	}
	
	// 返回最大元素
	public T max() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		int maxIndex = 0;
		int len = size();
		for (int i=1;i<len;i++) {
			if (less(maxIndex,i)) {
				maxIndex = i;
			}
		}
		return pq.get(maxIndex);
	}
	
	// 删除并返回最大元素
	public T delMax() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		int maxIndex = 0;
		int len = size();
		for (int i=1;i<len;i++) {
			if (less(maxIndex,i)) {
				maxIndex = i;
			}
		}
		T maxElement = pq.get(maxIndex);
		pq.remove(maxIndex);
		return maxElement;
	}
	
	// 遍历
	public void print() {
		/*
		 * for循环
		int len = size();
		for (int i=0;i<len;i++) {
			System.out.print(priorityQueue.get(i)+" ");
		}
		System.out.println();
		*/
		// 迭代器实现遍历
		Iterator<T> iterator = pq.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
	}
	
	private boolean less(int i, int j) {
		return pq.get(i).compareTo(pq.get(j))<0;
	}
}
