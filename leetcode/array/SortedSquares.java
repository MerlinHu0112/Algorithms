package leetcode.array;

/**
 * @date 2019-12-04
 * @author Merlin
 *	题目：# 977. 有序数组的平方
 *
 */
public class SortedSquares {

	public int[] sortedSquares(int[] A) {
		
		int len = A.length;
		int pos = 0; // 非负数指针
		
		while(pos<len && A[pos]<0) {
			pos++;
		}
		int neg = pos-1; // 负数指针
		
		int[] res = new int[len];
		int cnt = 0;
		
		while(neg>=0 && pos<len) {
			if(A[pos]*A[pos] <= A[neg]*A[neg]) {
				res[cnt++] = A[pos]*A[pos];
				pos++;
			}else {
				res[cnt++] = A[neg]*A[neg];
				neg--;
			}
		}
		
		while(pos<len) {
			res[cnt++] = A[pos]*A[pos];
			pos++;
		}
		
		while(neg>=0) {
			res[cnt++] = A[neg]*A[neg];
			neg--;
		}
		
		return res;
    }
}
