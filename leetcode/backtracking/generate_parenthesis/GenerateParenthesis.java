package leetcode.backtracking.generate_parenthesis;

import java.util.ArrayList;
import java.util.List;
/**
 * @date 2020-01-30
 * @author Merlin
 *	#22.括号生成：给定括号对数n，返回所有合法（合法：左右括号成对出现）的括号集合
 *	回溯算法 & 深度优先搜索
 */
public class GenerateParenthesis {
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String auxString = new String();
        backtrack(result, n, 0, 0, auxString);
        return result;
    }
	
	/**
	 * @param number 给定的括号对数
	 * @param left 当前已有的左括号个数
	 * @param right 当前已有的右括号个数
	 * @param curr 当前括号串
	 * 函数思路：
	 *		1、首先判断当前括号串是否符合要求，若是则放入result中；
	 *		2、当前还有左括号可用，优先插入左括号；
	 *		3、当前右括号的数量小于左括号，则可插入右括号。
	 */
	private void backtrack(List<String> result, int number, int left,
			int right, String curr) {
		// 当前括号串的长度已符号给定的括号对数，放入result中
		if(curr.length()== 2*number) {
			result.add(curr);
			return;
		}
		
		// 当前还有左括号可以使用，优先产生左分支
		if(left < number) {
			backtrack(result, number, left+1, right, curr+"(");
		}
		
		// 当前右括号数小于左括号数，则可产生右分支（注意，左分支优先）
		if(right < left) {
			backtrack(result, number, left, right+1, curr+")");
		}
	}
}
