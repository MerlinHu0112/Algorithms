package listsort;

import java.util.Random;

/**
 * 工具类：生成随机链表、打印链表
 * @author Merlin
 * @date 2020-03-25
 */
public class Utils {
	
	/*
	 * 生成指定长度的随机链表。结点元素值在[0,100)区间内。
	 * 返回链表头节点地址。
	 */
	public static ListNode generateList(int length) {
		Random random = new Random();
		int val = random.nextInt(100); // [0,100)内的随机整数
		ListNode head = new ListNode(val);
		ListNode p = head;
		for(int i=1; i<=length-1; i++) {
			p.next = new ListNode(random.nextInt(100));
			p = p.next;
		}
		return head;
	}
	
	/*
	 * 打印链表
	 */
	public static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	/*
	 * 检验链表是否有序
	 */
	public static void check(ListNode head) {
		boolean flag = true;
		while(head.next!=null) {
			if(head.val > head.next.val) {
				flag = false;
				break;
			}
			head = head.next;
		}
		if(flag==false) {
			System.out.println("链表无序");
		}else {
			System.out.println("链表有序");
		}
	}
	
	/*
	 * 生成指定长度的随机数组。结点元素值在[0,100)区间内。
	 */
	public static int[] generateArray(int length) {
		Random random = new Random();
		int[] arr = new int[length];
		for(int i=0; i<length; i++) {
			arr[i] = random.nextInt(100);
		}
		return arr;
	}

	/*
	 * 打印数组
	 */
	public static void printArray(int[] arr) {
		for(int ele : arr) {
			System.out.print(ele+" ");
		}
		System.out.println();
	}
	
	/*
	 * 交换数组元素
	 */
	public static void exch(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/*
	 * 检验数组是否有序
	 */
	public static void check(int[] arr) {
		boolean flag = true;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				flag = false;
				break;
			}
		}
		if(flag==false) {
			System.out.println("数组无序！");
		}else {
			System.out.println("数组有序！");
		}
	}
}
