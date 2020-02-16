package algorithms.sort;

import java.util.Random;
/*
 *	排序算法父类，定义了公用方法
 *	选择数组元素为Integer类型
 */
@SuppressWarnings("all")
public class SortUtil {

	// 定义产生随机数组的方法，随机数的范围由用户指定
	public static Integer[] generateIntegerArray(int array_length, int array_range) {
		Random random = new Random();
		int len = array_length;
		Integer[] array = new Integer[len];
		for (int i=0;i<len;i++) {
			array[i] = random.nextInt(array_range);
		}
		return array;
	}
	
	// 定义拷贝数组的方法
	public static Integer[] copyArray(Integer[] oldArray) {
		int len = oldArray.length;
		Integer[] newArray = new Integer[len];
		for (int i=0;i<len;i++) {
			newArray[i] = oldArray[i];
		}
		return newArray;
	}
	
	// 定义打印数组的方法
	public static void print(Integer[] array) {
		int len = array.length;
		int count = 0;
		for (int i=0;i<len;i++) {
			System.out.print(array[i]+" ");
			count++;
			if (count % 10 == 0) {
				System.out.println();
			}
		}
	}
	
	// 比较算法
	public static boolean less(Integer a, Integer b) {
		return a.compareTo(b)<0; // a<b时，true；否则false
	}
	
	// 交换元素
	public static void exch(Integer[] array, Integer i, Integer j) {
		Integer temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// 测试是否有序
	public static boolean isSorted(Integer[] array) {
		for(int i=1;i<array.length;i++) {
			if (less(array[i], array[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	// 查找最大元素值，并返回索引
	public static int findMaxIndex(Integer[] array) {
		int maxIndex = 0;
		int maxElement = array[maxIndex];
		int nowElement = 0;
		for (int i=0;i<array.length;i++) {
			nowElement = array[i];
			if (less(maxElement, nowElement)) {
				maxElement = nowElement;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
}
