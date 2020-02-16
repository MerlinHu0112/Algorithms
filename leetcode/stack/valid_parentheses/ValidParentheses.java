package leetcode.stack.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * @date 2020-02-15
 * @author Merlin
 *	#20.有效的括号
 */
public class ValidParentheses {
	
	public boolean isValid(String s) {

        int len = s.length();
        
        // 空字符串视为有效字符串
        if(len==0){
            return true;
        }

        // 字符串s的长度为奇数，一定为无效字符串
        if((len % 2)!=0){
            return false;
        }

        /*
         * 利用栈辅助，若当前字符与栈顶字符匹配，则弹出栈顶字符；
         * 若当前字符与栈顶字符不匹配，则压入栈中。最后，若栈中
         * 仍有字符，为false；栈为空，为true。
         */
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i=0;i<len;i++){
            if(!stack.isEmpty()){
                if(((s.charAt(i)==')')&&(stack.peek().equals(new Character('('))))||
                		((s.charAt(i)=='}')&&(stack.peek().equals(new Character('{'))))||
                		((s.charAt(i)==']')&&(stack.peek().equals(new Character('['))))) {
                	stack.pop();
                }else{
                	stack.push(new Character(s.charAt(i)));
                }
            }else{
            	stack.push(new Character(s.charAt(i)));
            }
        }
        
        if(!stack.isEmpty()) {
        	return false;
        }
        return true;
    }
}
