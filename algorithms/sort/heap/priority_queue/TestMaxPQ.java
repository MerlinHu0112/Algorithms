package algorithms.sort.heap.priority_queue;

import org.junit.Test;

/*
 *	测试自实现的优先队列，包括UnorderArrayMaxPQ类、OrderArrayMaxPQ类、
 *	UnorderLinkedListMaxPQ类、OrderLinkedListMaxPQ类、
 *	UnorderArrayListMaxPQ类、OrderArrayListMaxPQ类
 */
@SuppressWarnings("all")
public class TestMaxPQ {
	
	@Test
	// 测试PriorityQueueUnorderArray类
	public void unorderArray() {
		UnorderArrayMaxPQ pq = new UnorderArrayMaxPQ(5);
		pq.insert(12);
		pq.insert(1);
		pq.insert(7);
		pq.insert(5);
		pq.insert(3);
		System.out.println("优先队列中现有"+pq.size()+"个元素");
		pq.print();
		System.out.println("当前最大元素为："+pq.max());
		pq.delMax();
		System.out.println("删除最大元素后，优先队列目前还有"+pq.size()+"个元素，当前最大"
				+ "元素为："+pq.max());
		pq.print();
	}
	
	@Test
	// 测试PriorityQueueOrderArray类
	public void orderArray() {
		OrderArrayMaxPQ pq = new OrderArrayMaxPQ(5);
		pq.insert(22);
		pq.insert(31);
		pq.insert(17);
		pq.insert(5);
		pq.insert(88);
		System.out.println("优先队列中现有"+pq.size()+"个元素");
		pq.print();
		System.out.println("当前最大元素为："+pq.max());
		pq.delMax();
		System.out.println("删除最大元素后，优先队列目前还有"+pq.size()+"个元素，当前最大"
				+ "元素为："+pq.max());
		pq.print();
	}
	
	@Test
	// 测试PriorityQueueUnorderLinkedList类
	public void unorderLinkedList() {
		UnorderLinkedListMaxPQ pq = new UnorderLinkedListMaxPQ();
		pq.insert(22);
		pq.insert(31);
		pq.insert(17);
		pq.insert(5);
		pq.insert(18);
		System.out.println("优先队列中现有"+pq.size()+"个元素");
		pq.print();
		System.out.println("当前最大元素为："+pq.max());
		pq.delMax();
		System.out.println("删除最大元素后，优先队列目前还有"+pq.size()+"个元素，当前最大"
				+ "元素为："+pq.max());
		pq.print();
	}
	
	@Test
	// 测试PriorityQueueOrderLinkedList类
	public void orderLinkedList() {
		OrderLinkedListMaxPQ pq = new OrderLinkedListMaxPQ();
		pq.insert(12);
		pq.insert(51);
		pq.insert(17);
		pq.insert(5);
		pq.insert(28);
		System.out.println("优先队列中现有"+pq.size()+"个元素");
		pq.print();
		System.out.println("当前最大元素为："+pq.max());
		pq.delMax();
		System.out.println("删除最大元素后，优先队列目前还有"+pq.size()+"个元素，当前最大"
				+ "元素为："+pq.max());
		pq.print();
	}
	
	@Test
	// 测试PriorityQueueUnorderArrayList类
	public void unorderArrayList() {
		UnorderArrayListMaxPQ pq = new UnorderArrayListMaxPQ();
		pq.insert(2);
		pq.insert(15);
		pq.insert(49);
		pq.insert(5);
		pq.insert(28);
		pq.insert(1);
		System.out.println("优先队列中现有"+pq.size()+"个元素");
		pq.print();
		System.out.println("当前最大元素为："+pq.max());
		pq.delMax();
		System.out.println("删除最大元素后，优先队列目前还有"+pq.size()+"个元素，当前最大"
				+ "元素为："+pq.max());
		pq.print();
	}
	
	@Test
	// 测试PriorityQueueOrderArrayList类
	public void orderArrayList() {
		OrderArrayListMaxPQ pq = new OrderArrayListMaxPQ();
		pq.insert(2);
		pq.insert(5);
		pq.insert(7);
		pq.insert(15);
		pq.insert(8);
		pq.insert(1);
		System.out.println("优先队列中现有"+pq.size()+"个元素");
		pq.print();
		System.out.println("当前最大元素为："+pq.max());
		pq.delMax();
		System.out.println("删除最大元素后，优先队列目前还有"+pq.size()+"个元素，当前最大"
				+ "元素为："+pq.max());
		pq.print();
	}
}
