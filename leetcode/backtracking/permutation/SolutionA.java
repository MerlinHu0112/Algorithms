package leetcode.backtracking.permutation;

import java.util.ArrayList;
import java.util.List;
/**
 * @date 2020-02-08
 * @author Merlin
 * #46.全排列：给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class SolutionA {
	public List<List<Integer>> permute(int[] nums) {
		
		/*
		 * 2020-02-16:我的解法，未通过，仅输出原数组，并未实现排列组合
		 */
		
        // 回溯算法实现，关键在于先在某位置插入一个数值，之后一定会回溯到
        // 此位置并选择其它值，直至尝试完所有值
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length==0){
            return result;
        }
        
        List<Integer> numsList = new ArrayList<>(); // 当前待选择元素的集合
        List<Integer> resList = new ArrayList<>(); // 当前已插入元素的集合
        for(int ele:nums) {
        	numsList.add(ele);
        }
        
        backtrack(nums, numsList, resList, result); // 调用回溯方法处理
        return result;
    }

    // 回溯算法
    private void backtrack(int[] nums, List<Integer> numsList, 
    		List<Integer> resList, List<List<Integer>> result){
        // 已插入所有数字
        if(resList.size()==nums.length) {
        	result.add(new ArrayList<Integer>(resList));
        	return;
        }

        // 回溯过程，隐式地建立一棵树，结果集取全部叶子结点即可
        for(int i=0; i<numsList.size(); i++) {
        	resList.add(numsList.get(i)); // 首先向已插入元素的集合中添加元素
        	numsList.remove(i); // 然后在待选择元素的集合中移除该元素
        	backtrack(nums, numsList, resList, result); // 递归进入下一层
        }
    }
}
