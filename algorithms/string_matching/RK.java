package algorithms.string_matching;
/**
 * 字符串匹配算法之RK（Robin-Karp）算法，哈希算法。
 * RK算法的核心在于：通过计算串的哈希值来优化比较时间。
 * 值得警惕的是，哈希值相等并不等价于字符串匹配。
 * m-主串字符个数
 * n-模式串字符个数
 * @author Merlin
 * @date 2020-03-03
 */
public class RK {
	
	/**
	 * @param string 主串
	 * @param pattern 模式串
	 * @return 返回模式串在主串中首次出现的位置，若无则返回-1。
	 */
	public static int robinKarp(String string, String pattern) {
	    // 主串长度
	    int m = string.length();
	    // 模式串的长度
	    int n = pattern.length();
	    // 计算模式串的哈希值
	    int patternCode = firstHash(pattern);
	    // 计算主串当中第一个和模式串等长的子串哈希值
	    int strCode = firstHash(string.substring(0, n));
	    // 用模式串的哈希值和主串的局部哈希值比较。
	    // 如果匹配，则进行精确比较；如果不匹配，计算主串中相邻子串的哈希值。
	    // 外层循环的最大循环次数为 m-n+1。
	    for (int i=0; i<m-n+1; i++) {
	        if(strCode == patternCode && compareString(i, string, pattern)){
	            return i; 
	        }
	        // 如果不是最后一轮，更新主串从i到i+n的哈希值
	        if(i<m-n){
	        	strCode = nextHash(string, strCode, i, n); 
	        } 
	    }
	    return -1;
	}
	
	// 首次计算主串和模式串的哈希值
	private static int firstHash(String str) {
	    int hashcode = 0;
	    // 这里采用最简单的哈希值计算方式：
	    // 把a当做0，把b当中1，把c当中2.....然后按位相加
	    for(int i = 0; i < str.length(); i++) { 
	        hashcode += str.charAt(i)-'a'; 
	    }
	    return hashcode;
	}

	private static int nextHash(String string, int hashCode, int index, int n){ 
	    hashCode -= string.charAt(index)-'a'; 
	    hashCode += string.charAt(index+n)-'a';
	    return hashCode;
	}
	
	// 因存在哈希冲突，当哈希值相同时，仍需要额外逐位比对字符串
	private static boolean compareString(int start, String string, String pattern){ 
	    String subString = string.substring(start, start+pattern.length());
	    return subString.equals(pattern);
	}
	
	// *************************************************
	
	/**
	 * improvedRobinKarp方法较robinKarp方法，前者采用不同的哈希值计算方法
	 * 注意！代码实现似乎有问题，暂时没想明白！
	 * @param string 主串
	 * @param pattern 模式串
	 * @return 返回模式串在主串中首次出现的位置，若无则返回-1。
	 */
	public static int improvedRobinKarp(String string, String pattern) {
	    // 主串长度
	    int m = string.length();
	    // 模式串的长度
	    int n = pattern.length();
	    // 26个字母，二十六进制
	    int d = 26;
	    // 用计算得到的哈希值对q取模，防止哈希值溢出
	    // q为满足(q*d < MAX_INT)的随机素数
	    int q = 144451;
	    // h标记字符串高位字符的基数
	    int h = 1;
	    
	    // 主串的初始哈希值
	    int strCode = string.charAt(0)-'a';
	    // 模式串的初始哈希值
	    int patternCode = pattern.charAt(0)-'a';
	    
	    // 首次计算主串和模式串的哈希值
	    for(int i=1; i<n; ++i) {
	    	strCode = (strCode * d + string.charAt(i)-'a') % q;
	    	patternCode = (patternCode * d + pattern.charAt(i)-'a') % q;
	    	h = (h * d) % q;
	    }
	    
	    // 用模式串的哈希值和主串的局部哈希值比较。
	    // 如果匹配，则进行精确比较；如果不匹配，计算主串中相邻子串的哈希值。
	    for (int i=0; i<m-n+1; i++) {
	        if(strCode == patternCode && compareString(i, string, pattern)){
	            return i; 
	        }
	        if(i < m-n) {
	        	// 更新主串从i到i+n的哈希值
	        	strCode = ((strCode - h*(string.charAt(i)-'a'))*d + (string.charAt(i+n)-'a')) % q;
	        }
	        if(strCode < 0) {
	        	strCode += q;
	        }
	    }
	    return -1;
	}
}
