package listsort;
/**
 * 测试类
 * @author Merlin
 * @date 2020-03-25
 */
public class Demo {
	public static void main(String[] args) {
		int[] arr = Utils.generateArray(10000);
		Utils.check(arr);
		ShellSort.sort(arr);
		Utils.check(arr);
	}
	
	public void function_1() {
		int[] arr = Utils.generateArray(10000);
		Utils.check(arr);
		SelectionSort.sort(arr);
		Utils.check(arr);
	}
	
	public void function_2() {
		ListNode head = Utils.generateList(10000);
		Utils.check(head);
		SelectionSort.sort(head);
		Utils.check(head);
	}
}
