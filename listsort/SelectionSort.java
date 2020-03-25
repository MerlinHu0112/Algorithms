package listsort;
/**
 * 单链表选择排序
 * @author Merlin
 * @date 2020-03-25
 */
public class SelectionSort {
	
	// 数组的选择排序
	public static void sort(int[] arr) {
		if(arr==null) {
			return;
		}
		for(int i=0; i<arr.length; i++) {
			int min = i; // 当前内循环最小值索引
			// 内循环从i开始，即[0,i-1]区间已有序
			for(int j=i; j<arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	// 单链表的选择排序
	public static void sort(ListNode head) {
		if(head==null) {
			return;
		}
		ListNode p;
		ListNode start = head; // 内循环起始节点
		ListNode minNode; // 当前内循环最小值节点
		int temp;
		while(start.next!=null) {
			minNode = start;
			p = start.next;
			while(p!=null) {
				if(p.val < minNode.val) {
					minNode = p;
				}
				p = p.next;
			}
			// 结束内循环，交换元素
			temp = start.val;
			start.val = minNode.val;
			minNode.val = temp;
			Utils.printList(head);
			start = start.next; // 每结束一次内循环，起始节点变为后继节点
		}
	}
}
