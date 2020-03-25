package listsort;
/**
 * 单链表冒泡排序
 * @author Merlin
 * @date 2020-03-25
 */
public class BubbleSortList {
	
	/*
	 * 数组的冒泡排序
	 */
	public static void sort(int[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<arr.length-i; j++) {
				if(arr[j] > arr[j+1]) {
					Utils.exch(arr, j, j+1);
				}
			}
		}
	}
	
	/*
	 * 链表的冒泡排序。限定使用指针。
	 */
	public static void sort(ListNode head) {
		if(head==null) {
			return;
		}
		
		ListNode p;
		ListNode tail = null; // 标记内循环的结束位置
		int temp;
		int count; // 记录每次内循环时交换元素的次数
		while(tail!=head) {
			count = 0;
			p = head; // 内循环总是从头节点开始
			while(p.next!=tail) {
				if(p.val > p.next.val) {
					temp = p.val;
					p.val = p.next.val;
					p.next.val = temp;
					count++;
				}
				p = p.next;
			}
			// 内循环结束时，p指针位置是
			// 下一轮内循环tail指针的位置
			tail = p;
			// 经过一次内循环，count仍为0，
			// 说明未发生交换，即链表已有序。
			if(count==0) {
				return;
			}
		}
	}
}
