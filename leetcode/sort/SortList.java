package leetcode.sort;

/*
 *	2019-11-26
 *	# 148.排序链表
 *	要求：在O(n log n)时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
@SuppressWarnings("all")
public class SortList {
	
	private ListNode head; // 头指针
	private Integer[] a;
	private Integer[] aux;

	private class ListNode {
		private int val;
		private ListNode next;
		
		public ListNode(int x) {
			this.val = x;
		}
	}
	
	/*
	public ListNode sortList(ListNode head) {
		transferList(head);
		
	}*/
	
	// 将单链表按元素顺序转换成数组，并创建辅助数组aux
	private void transferList(ListNode head) {
		int count = 0;
		ListNode pListNode = head;
		while(pListNode!=null) {
			count++;
			pListNode = pListNode.next;
		}
		a = new Integer[count];
		pListNode = head;
		for(int i=0;i<a.length;i++) {
			a[i] = head.val;
			
		}
		aux = new Integer[count];
	}
	
	
}
