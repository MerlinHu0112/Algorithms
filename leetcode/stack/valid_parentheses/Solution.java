package leetcode.stack.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
/**
 * @date 2020-02-15
 * @author Merlin
 *	#20.有效的括号
 *	参考题解，使用Map保存括号对，使代码更加直观。其中，
 *	key为闭括号，value为开括号。
 */
public class Solution {
	/*
	 * 利用栈后进先出（LIFO）的特点。
	 * 当前括号为开括号时，直接将其压入栈中；
	 * 当前括号为闭括号时，仅当栈顶元素为匹配的开括号时，
	 * 才可消除，否则直接返回false。
	 */
	
	/*
	 * 利用HashMap保存括号对，其中：
	 * key -- 闭括号
	 * value -- 开括号
	 */
	private HashMap<Character, Character> auxMap = new HashMap<>();
	
	public Solution() {
		this.auxMap.put(')', '(');
		this.auxMap.put('}', '{');
		this.auxMap.put(']', '[');
	}
	
	public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	// 若当前括号为闭括号，弹出栈顶元素，并与当前括号匹配
        	if(this.auxMap.containsKey(c)) {
        		// 若栈顶元素为空，返回'*'作为辅助字符；否则弹出栈顶元素
        		char topEle = stack.isEmpty() ? '*' : stack.pop();
        		// 判断栈顶括号是否与当前括号匹配
        		if(topEle != this.auxMap.get(c)) {
        			// 栈顶元素为空，或栈顶括号与当前括号不匹配
        			return false;
        		}
        	}else {
        		// 当前括号为开括号，压入栈中
        		stack.push(c);
        	}
        }
        // 结束循环后，此时若栈为空，则返回true，否则返回false
        return stack.isEmpty();
	}
}
