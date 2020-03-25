package listsort;
/**
 * 单链表希尔排序
 * @author Merlin
 * @date 2020-03-25
 */
public class ShellSort {
	
	// 数组的希尔排序
	public static void sort(int[] arr) {
		if(arr==null) {
			return;
		}
		int len = arr.length;
		int h = 1;
		int temp;
		while(h < len/3) {
			h = 3*h + 1; // 设置间隔h的递增序列为1, 4, 13, 40, ...
		}
		while(h>=1) {
			for(int i=h; i<len; i++) {
				for(int j=i; j>=h && (arr[j] < arr[j-h]); j-=h) {
					temp = arr[j];
					arr[j] = arr[j-h];
					arr[j-h] = temp;
				}
			}
			h = h/3;
		}
	}
	
	// 单链表的希尔排序
	public static void sort(ListNode head) {
		if(head==null) {
			return;
		}
		
	}
}
