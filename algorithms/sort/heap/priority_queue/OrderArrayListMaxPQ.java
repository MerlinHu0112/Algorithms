package algorithms.sort.heap.priority_queue;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 	2019-10-11
 *	优先队列(Priority Queue)初级实现之六：有序数组(Order ArrayList)实现
 */
public class OrderArrayListMaxPQ <T extends Comparable<T>> {

	private ArrayList<T> pq;
	
	// 构造方法
	public OrderArrayListMaxPQ() {
		pq = new ArrayList<T>();
	}
	
	// 返回队列是否为空
	public boolean isEmpty() {
		return pq.isEmpty();
	}
	
	// 返回优先队列中的元素个数
	public int size() {
		return pq.size();
	}
	
	// 向优先队列中插入一个元素
	public void insert(T element) {
		if (isEmpty()) {
			pq.add(element);
		}else {
			int len = size();
			pq.add(element);
			for(int i=len; i>0 && less(i, i-1); i--) {
				exch(i, i-1);
			}
		}
	}
	
	// 返回最大元素
	public T max() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		return pq.get(size()-1);
	}
	
	// 删除并返回最大元素
	public T delMax() {
		if (isEmpty()) {
			throw new RuntimeException("The priority queue is empty");
		}
		return pq.remove(size()-1);
	}
	
	// 遍历
	public void print() {
		Iterator<T> iterator = pq.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
	}
	
	private boolean less(int i, int j) {
		return pq.get(i).compareTo(pq.get(j))<0;
	}
	
	private void exch(int i, int j) {
		T temp = pq.get(i);
		pq.set(i, pq.get(j));
		pq.set(j, temp);
	}
}
