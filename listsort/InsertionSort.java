package listsort;
/**
 * 单链表插入排序
 * @author Merlin
 * @date 2020-03-25
 */
public class InsertionSort {
	
	// 数组的插入排序
	public static void sort(int[] arr) {
		if(arr==null) {
			return;
		}
		// 从第一个元素开始，该元素可以认为已经被排序。
	    for(int i=1; i<arr.length; i++) {
	        int temp = arr[i];
	        int j;
	        // 取出下一个元素，在已经排序的元素序列中从后向前扫描。
	        // 通过内循环找到temp插入的位置
	        for(j=i; j>0 && (temp < arr[j-1]); j--) {
	            arr[j] = arr[j-1];
	        }
	        arr[j] = temp;
	    }
	}
	
	// 单链表的插入排序
	public static void sort(ListNode head) {
		if(head==null) {
			return;
		}
		ListNode tail = head.next; // 内循环结束节点
		ListNode p;
		int temp;
		while(tail!=null) {
			p = head; // 内循环每次从头节点开始
			while(p!=tail) {
				if(p.val > tail.val) {
					temp = p.val;
					p.val = tail.val;
					tail.val = temp;
				}
				p = p.next;
			}
			tail = tail.next;
		}
	}
}
