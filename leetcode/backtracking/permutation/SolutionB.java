package leetcode.backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-02-16
 * @author Merlin
 * #46.全排列：给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class SolutionB {
	public List<List<Integer>> permute(int[] nums) {
		/*
		 * 参考他人的解答：
		 * 1、维护一个标志数组，其保存数组nums中每一个元素的访问信息：
		 *    1-已访问过，0-未访问。
		 * 2、每次循环时，均遍历标志数组直至找到第一个未被访问的元素，将其
		 *    加入缓存集合cache。待缓存集合已满，将其加入到结果集中。
		 */
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] flag = new int[nums.length]; // 标志数组，默认为0，即未访问
		backtrack(nums, result, flag, new ArrayList<Integer>());
		return result;
	}
	
	// 实现回溯过程
	private void backtrack(int[] nums, List<List<Integer>> result, 
									int[] flag, List<Integer> cache) {
		// 缓存集合cache已满，将其加入到结果集中并返回
		if(cache.size()==nums.length) {
			result.add(new ArrayList<Integer>(cache));
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(flag[i]==1) {
				continue; // 若当前元素已被访问，则直接跳过后续代码执行"i++" 
			}
			// 当前元素未被访问，将其加入缓存集合，并将标志位设为"1"
			cache.add(nums[i]);
			flag[i] = 1;
			// 回溯【重点】：递归选择下一个未被访问的元素
			backtrack(nums, result, flag, cache);
			// 将刚访问过的第i个元素标志位重设为"0"，并从缓存集合中移除该元素，在
			// "此位置"尝试第i+1个元素
			flag[i] = 0;
			cache.remove(cache.size()-1);
		}
	}
}
