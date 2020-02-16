package leetcode.backtracking.power_set;

import java.util.ArrayList;
import java.util.List;
/**
 * @date 2020-01-29
 * @author Merlin
 * #78.回溯算法求幂集
 */
public class PowerSet {
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
	
	/**
	 * 回溯算法：逐个将nums数组元素添加至辅助集合auxList中，利用深度优先搜索，其中每一层
	 * 分为是否添加当前元素，左孩子结点表示添加，右孩子结点表示不添加。最终，读取二叉树的
	 * 根结点和所有左孩子结点，即为所求的幂集。
	 */
	private void backtrack(int[] nums, int start, List<Integer> auxList, 
			List<List<Integer>> result){
		result.add(new ArrayList<Integer>(auxList)); // 向结果集中添加元素
		for(int i=start; i<nums.length; i++) {
			auxList.add(nums[i]);
			backtrack(nums, i+1, auxList, result); // 递归
			auxList.remove(auxList.size()-1); // 移除当前auxList中的最后一个元素
		}
	}
}
