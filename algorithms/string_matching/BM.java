package algorithms.string_matching;
/**
 * 字符串匹配算法之BM（Boyer-Moore）算法
 * m-主串字符个数
 * n-模式串字符个数
 * @author Merlin
 * @date 2020-03-03
 */
public class BM {
	public static void main(String[] args) {
		String string = Utils.readString();
		String pattern = "gcuyac";
		int result = boyerMoore(string, pattern);
		System.out.println("模式串在主串中首次出现位置为："+result);
	}
	
	/**
	 * @param string 主串
	 * @param pattern 模式串
	 * @return 返回模式串在主串中首次出现的位置，若无则返回-1。
	 */
	private static int boyerMoore(String string, String pattern) {
		int m = string.length();
		int n = pattern.length();
		
		// 开始时，主串和模式串从0至pattern.length-1位一一对应
		int start = 0; // 模式串对应主串的起始位置
		
		while(start <= (m-n)) {
			// 从右往左寻找坏字符，其中坏字符位于主串
			int i;
			for(i = n-1; i >= 0; i--) {
				if(string.charAt(start+i) != pattern.charAt(i)) {
					break;
				}
			}
			
			// 未找到坏字符，即一一匹配，返回结果
			if(i < 0) {
				return start;
			}
			
			// 找到坏字符，确定模式串移动距离
			int badCharIndex = findBadCharacter(string.charAt(start+i), pattern, i); // 模式串中寻找坏字符从i-1开始
			// 计算坏字符产生的位移
			int offset = badCharIndex >= 0 ? i-badCharIndex : i+1;
			start += offset;
		}
		return -1;
	}
	
	/**
	 * @param badChar 坏字符
	 * @param pattern 模式串
	 * @param start 坏字符索引
	 * @return 返回模式串中坏字符的位置，不存在则返回-1
	 */
	private static int findBadCharacter(char badChar, String pattern, int start) {
		for(int i = start-1; i>=0; i--) {
			if( badChar == (pattern.charAt(i)) ) {
				return i;
			}
		}
		return -1;
	}
}
