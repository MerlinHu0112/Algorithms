package leetcode.array;

import java.util.Arrays;
/**
 * @date 2019-12-05
 * @author Merlin
 * 题目：等价多米诺骨牌对的数量
 *
 */
public class DominoPairs {
	public int numEquivDominoPairs(int[][] dominoes) {
		int count = 0;
		int[] aux = new int[100];
		for(int[] arr : dominoes) {
			Arrays.sort(arr);
			count += aux[10*arr[0]+arr[1]];
		}
		return count;
	}
}
