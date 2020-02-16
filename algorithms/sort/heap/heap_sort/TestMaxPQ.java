package algorithms.sort.heap.heap_sort;

import org.junit.Test;
/*
 *	测试MaxPQ类
 */
@SuppressWarnings("all")
public class TestMaxPQ {
	
	@Test
	// 测试MaxPQ类
	public void function() {
		MaxPQ pq = new MaxPQ(0); // "0"为pq[0]的占位元素
		pq.insert(33);
		pq.insert(12);
		pq.insert(9);
		pq.insert(13);
		pq.insert(6);
		pq.insert(21);
		pq.insert(8);
		System.out.println("优先队列中现有"+pq.size()+"个元素");
		pq.print();
		System.out.println("当前最大元素为："+pq.max());
		pq.delMax();
		System.out.println("删除最大元素后，优先队列目前还有"+pq.size()+"个元素，当前最大"
				+ "元素为："+pq.max());
		pq.print();
	}
}
