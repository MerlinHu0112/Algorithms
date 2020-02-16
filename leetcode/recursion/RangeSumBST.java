package leetcode.recursion;

/**
 * @date 2019-12-03
 * @author Merlin
 * 题目：# 938.二叉搜索树的范围和
 * 		给定L和R，返回二叉搜索树中元素值位于L和R之间（包括L和R）的所有结点的值的和
 */
@SuppressWarnings("all")
public class RangeSumBST {
	
	private class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int val) { 
			this.val = val; 
		}
	}

	/*
	 *解题思路：中序遍历二叉树，即可得到按升序排列的结点值序列
	 */
	private int sum = 0; // 用于保存结果
	
	public int rangeSumBST(TreeNode root, int L, int R) {
		
        if(root==null) {
        	return 0;
        }
        
        if(root.left!=null && root.val > L) {
        	 // 左子结点不为空，且父结点值大于L时，方可递归进入下一层
        	rangeSumBST(root.left, L, R);
        }
        
        if(root.val>=L && root.val<=R){
            sum += root.val;
        }
        
        if(root.right!=null && root.val < R) {
        	// 右子结点不为空，且父结点值小于R时，方可递归进入下一层
        	rangeSumBST(root.right, L, R);
        }
        
        return sum;
    }
}
