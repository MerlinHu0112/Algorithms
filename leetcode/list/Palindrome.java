package leetcode.list;

/**
 * @date 2019-12-09
 * @author Merlin
 * 题目：给定一个单链表，判断其是否为回文链表（从前往后和从后往前读取，结果一样）。
 *
 */
@SuppressWarnings("all")
public class Palindrome {
	
	private class ListNode {

		private int val;
		private ListNode next;
		
		public ListNode(int x) {
			this.val = x;
		}
	}
	
	public boolean isPalindrome(ListNode head) {
		/*
		 *	参考@outsider的解答
		 *	要点：
		 *		1、利用快慢指针，实现二分链表（慢指针每走一部，快指针走两步）；
		 *		2、快慢指针移动过程中，实现反转前段链表
		 */
		if(head==null || head.next==null){
            return true;
        }
		
        ListNode slow = head;
        ListNode fast = head.next;
        // 反转前段链表时需要用到的辅助指针，其中auxP指向当前
        // slow指针所指结点，auxQ指向auxP前一结点
        ListNode auxP = null, auxQ = null;
        
        // 二分链表，同时完成反转前段链表
        while(fast!=null && fast.next!=null) {
        	auxP = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        	auxP.next = auxQ; // 完成当前auxP指向的结点反转
        	auxQ = auxP;
        }
        
        // 上述循环结束，slow指向“中间”结点
        // 链表长度为奇数时，循环结束后，fast==null；
        // 链表长度为偶数，fast指向最后一个结点
        ListNode secSta = slow.next; // 后半段链表的起始结点指针
        slow.next = auxQ; // 链表前端最后一个结点反转，但它不一定参与下面的循环，这与链表长度的奇偶性相关
        ListNode firSta = fast == null ? auxQ : slow;
        
        // 遍历前、后半段链表，判断是否为回文数
        while(firSta!=null) {
        	if(firSta.val != secSta.val) {
        		return false;
        	}
        	firSta = firSta.next;
        	secSta = secSta.next;
        }
        
        return true;
    }
}
