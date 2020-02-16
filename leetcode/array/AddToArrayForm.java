package leetcode.array;

import java.util.ArrayList;
import java.util.List;
/**
 * @date 2019-12-07
 * @author Merlin
 * # 989. 数组形式的整数加法
 * # 题目要求：给定非负整数X的数组形式A，加[0, 10000]的整数K，返回数组形式
 * # 思路：切不可强行求出A（其值或溢出），须逐位计算，考虑进位及最终结果的首位是否非0
 */
public class AddToArrayForm {
	public List<Integer> addToArrayForm(int[] A, int K) {
		
		ArrayList<Integer> resList = new ArrayList<>();
		int A_len = A.length;
		
		// 若数组A的长度小于5，则新建长度为5的新数组，并填入A中数据，高位填充0
		if(A_len < 5) {
			int[] aux = new int[5];
			for(int i=0;i<A_len;i++) {
				aux[(5-A_len)+i] = A[i];
			}
			A = aux;
		}
		
		int[] aux = new int[A.length+1]; // 辅助数组恰好比A数组长1位
		int i = 1;
		for(int j=A.length-1;j>=0;j--) {
			int k = 0; // K最大为10000，若i超过5，则第i位必然为0
			if(i<=5) {
				k = (int) ((K % Math.pow(10, i)) / Math.pow(10, i-1)); // 求K第i位上的数字
			}
			int t = aux[j+1]; // 取辅助数组j+1位（与A数组j位相对应）的数，若上一步计算有进一位，则为1，否则为0
			if((A[j]+k+t) >= 10) {
				// 与A数组索引j对应的辅助数组索引j+1，若待插入数字大于9，则减10后插入，并向前进一位
				aux[j+1] = A[j]+k+t-10;
				aux[j] = 1;
			}else {
				aux[j+1] = A[j]+k+t; // 不需进位，直接插入
			}
			i++;
		}
		
		// 从辅助数组0索引开始，寻找首位非0值
		// 特殊情况是数组A只含一个0，且K为0
		int start = 0;
		while(start<aux.length-1) {
			if(aux[start]!=0) {
				break;
			}
			start++;
		}
		
		// 从辅助数组首个非0位开始，存入并返回List
		for(i=start;i<aux.length;i++) {
			resList.add(aux[i]);
		}
		return resList;
    }
}
