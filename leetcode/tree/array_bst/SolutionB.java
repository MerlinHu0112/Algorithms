package leetcode.tree.array_bst;

import leetcode.TreeNode;

// 在SolutionA的基础上优化空间复杂度（似乎与SolutionA差不多...）
public class SolutionB {
	
	private int[] nums; // 将nums保存为成员变量，避免频繁传nums参数
	
	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;
        return recursiveBuild(0, nums.length-1);
    }
	
	// 递归建立二叉树
	private TreeNode recursiveBuild(int lo, int hi) {
		// 终止递归的条件
		if(lo>hi) {
			return null;
		}
		// 以右中间值，新建根结点
		int mid = (hi+lo+1)>>1;
		TreeNode root = new TreeNode(nums[mid]);
		// 左半部分为根结点左子树
		root.left = recursiveBuild(lo, mid-1);
		// 右半部分为根结点右子树
		root.right = recursiveBuild(mid+1, hi);
		// 返回根结点索引
		return root;
	}
}
