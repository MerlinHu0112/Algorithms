package leetcode.tree.array_bst;
import leetcode.TreeNode;
/**
 * LeetCode #108.将有序数组转换为二叉搜索树
 * Q：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
 * （即二叉树中每个节点的左右两个子树的高度差的绝对值不超过1）
 * @date 2020-02-19
 * @author Merlin
 */
public class SolutionA {
	/*
	 * 本题采用递归的思想，将数组nums按右中间值划分为两段。中间值
	 * 保存为根结点，左半部分建成左子树，右半部分建成右子树。
	 * 
	 * 提交结果：通过
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
        return recursiveBuild(nums, 0, nums.length-1);
    }
	
	// 递归建立二叉树
	private TreeNode recursiveBuild(int[] nums, int lo, int hi) {
		// 终止递归的条件
		if(lo>hi) {
			return null;
		}
		// 以右中间值，新建根结点
		int mid = (hi+lo+1)>>1;
		TreeNode root = new TreeNode(nums[mid]);
		// 左半部分为根结点左子树
		root.left = recursiveBuild(nums, lo, mid-1);
		// 右半部分为根结点右子树
		root.right = recursiveBuild(nums, mid+1, hi);
		// 返回根结点索引
		return root;
	}
}
