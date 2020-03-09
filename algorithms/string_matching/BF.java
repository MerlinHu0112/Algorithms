package algorithms.string_matching;
/**
 * 字符串匹配算法之BF（Brute Force）算法，暴力法。
 * 暴力法的核心在于"逐位匹配"主串和模式串，时间复杂度为：O(m*n)
 * m-主串字符个数
 * n-模式串字符个数
 * @author Merlin
 * @date 2020-03-03
 */
public class BF {
	
	/**
	 * @param string 主串
	 * @param pattern 模式串
	 * @return 返回模式串在主串中首次出现的位置，若无则返回-1。
	 */
	public static int bruteForce(String string, String pattern) {
		for(int i=0; i<=((string.length())-(pattern.length())); ++i) {
			int j = 0;
			while(j<pattern.length()) {
				if(string.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
				j++;
			}
			if(j == pattern.length()) {
				return i;
			}
		}
		return -1;
	}
}
