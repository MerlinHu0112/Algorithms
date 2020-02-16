package leetcode.stack.valid_parentheses;

public class Test {
	public static void main(String[] args) {
		String str = "{{)}";
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid(str));
	}
}
