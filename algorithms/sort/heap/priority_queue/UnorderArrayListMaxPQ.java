package algorithms.sort.heap.priority_queue;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 	2019-10-11
 *	优先队列(Priority Queue)初级实现之五：无序数组(Unorder ArrayList)实现
 */
public class UnorderArrayListMaxPQ <T extends Comparable<T>> {

	private ArrayList<T> PQ;
	
	// 构造方法
	public UnorderArrayListMaxPQ() {
		PQ = new ArrayList<T>();
	}
	
	// 返回队列是否为空
	public boolean isEmpty() {
		return PQ.isEmpty();
	}
	
	// 返回优先队列中的元素个数
	public int size() {
		return PQ.size();
	}
	
	// 向优先队列中插入一个元素
	public void insert(T element) {
		PQ.add(element);
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
		return PQ.get(maxIndex);
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
		T maxElement = PQ.get(maxIndex);
		PQ.remove(maxIndex);
		return maxElement;
	}
	
	// 遍历
	public void print() {
		Iterator<T> iterator = PQ.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
	}
	
	private boolean less(int i, int j) {
		return PQ.get(i).compareTo(PQ.get(j))<0;
	}
	
}
