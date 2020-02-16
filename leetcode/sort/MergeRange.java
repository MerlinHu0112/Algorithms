package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * @date 2019-12-02
 * @author Merlin
 *	题目：合并给定的区间集合中重叠的区间，不重合的区间保持，返回区间集合（合并后的区间及独立的原区间）
 *
 */
@SuppressWarnings("all")
public class MergeRange {

	/*
	 *	我的思路：设置两个指针，内外循环，两两比较区间，若重合，则同时更新两个区间左右区间值。循环完毕，重复的区间值仅取一个即可
	 *	提交结果：未通过！！！暂未发现bug在何处
	 */
	//public int[][] merge(int[][] intervals){
		/*
		 *	将p指向的区间与其后每一个区间逐一比较，若重复，则同时更新p、q所指区间值
		 */
		/*for(int p=0; p<intervals.length-1; p++) { // p指针，外循环
			for(int q=p+1; q<intervals.length; q++) { // q指针，内循环
				if(intervals[p][0]<=intervals[q][0] && intervals[q][0]<=intervals[p][1]) {
					if(intervals[p][1]<=intervals[q][1]) {
						intervals[p][1]=intervals[q][1];
						intervals[q][0]=intervals[p][0];
					}else {
						intervals[q][0]=intervals[p][0];
						intervals[q][1]=intervals[p][1];
					}
				}else if(intervals[p][0] > intervals[q][0] && intervals[p][0]<=intervals[q][1]){
					if(intervals[p][1]<=intervals[q][1]) {
						intervals[p][0]=intervals[q][0];
						intervals[p][1]=intervals[q][1];
					}else {
						intervals[p][0]=intervals[q][0];
						intervals[q][1]=intervals[p][1];
					}
				}
			}
		}
		
		Set auxSet = new HashSet<Integer>();
		for(int i=0;i<intervals.length;i++) {
			auxSet.add(intervals[i][0]);
		}
		
		int[][] result = new int[auxSet.size()][2];
		Iterator<Integer> ite = auxSet.iterator();
		int cnt = 0;
		while(ite.hasNext()) {
			int tmp = ite.next();
			for(int i=0;i<intervals.length;i++) {
				if(tmp==intervals[i][0]) {
					result[cnt++] = intervals[i];
					break;
				}
			}
		}
		return result;
	}*/
	
	/*
	 *	参考他人的解答
	 *	思路：
	 *		1、先对所有区间按照左端点值升序排序；
	 *		2、一次遍历，将第一个区间插入merged数组中，然后按顺序考虑之后的每个区间；
	 *		3、若当前区间的左端点大于前一个区间的右端点，则区间不重合，直接插入当前区间；
	 *		4、若当前区间的左端点小于前一个区间的右端点，则区间重合，取较大的右端点更新重合区间的右端点。
	 */
	public int[][] merge(int[][] intervals){
		
		List<int[]> res = new ArrayList<>();
		
		/*
		 *	根据重写的比较器Comparator，实现对区间集合按照左端点值升序排序
		 *	sort()方法底层采用归并排序，时间复杂度为：O(n log n)
		 */
		Arrays.sort(intervals, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b) {
				return a[0]-b[0]; // 比较两个区间的左端点值
			}
		});
		
		/*
		 *	对区间集合进行遍历，仅需一次
		 */
		int i = 0;
		while(i < intervals.length) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			// 遍历，比较下一个区间的左端点值和当前区间i的右端点值
			while(i < intervals.length-1 && right > intervals[i+1][0]) {
				// i+1区间的左端点值小于i区间的右端点值，区间重合
				right = Math.max(right, intervals[++i][1]); // 取i和i+1区间右端点的较大者
			}
			res.add(new int[] {left, right}); // 向结果集中插入独立的区间
			i++;
		}
		return res.toArray(new int[0][]);
	}

}
