package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
	
	public int lastStoneWeight(int[] stones) {
		// 第一种解法太粗暴，既然是堆相关的题目，应尝试堆排序算法
        // 直接调用Java类库中的PriorityQueue（优先队列）实现，
		// 注意，PriorityQueue默认最小堆，需要重写Comparator函数可以实现大顶堆
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		// 向堆中插入元素，插入时已“有序”
		for(int ele : stones) {
			pq.offer(ele);
		}
		// 石头数量大于1，则执行两两粉碎
		while(pq.size()>1) {
			int y = pq.poll();
			int x = pq.poll();
			if(y-x!=0) {
				pq.offer(y-x);
			}
		}
		if(!pq.isEmpty()) {
			return pq.peek();
		}
		return 0;
    }
}
