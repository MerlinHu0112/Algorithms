package leetcode.tree.symmetric_binary_tree;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;
/**
 * LeetCode #101.对称二叉树
 * Q：给定一个二叉树，检查它是否是镜像对称的。
 * @date 2020-02-19
 * @author Merlin
 */
public class SolutionC {
	// 参考官方题解，迭代实现（基于深度优先搜索，BFS），但插入队列顺序与BSF有差异
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		
		// 开始时，根结点只有一个，将其存入两次
		queue.add(root);
		queue.add(root);
		
		// 当队列不为空时，每次取出两个连续的结点。
		// 当且仅当每次取出的两个结点值相等，才满足镜像对称
		while(!queue.isEmpty()) {
			TreeNode A = queue.poll();
			TreeNode B = queue.poll();
			
			// 结点A、B均为null，满足镜像对称，且需要跳过此次循环
			if(A==null && B==null) {
				continue;
			}
			
			// 结点A和结点B仅有一个为null，不满足镜像对称
			if(A==null || B==null) {
				return false;
			}
			
			// 结点A、B均不为null，且A、B结点值相同，按A左、B右、A右、B左的顺序插入孩子结点
			if(A.val!=B.val) {
				return false; // A、B结点值不同，不满足镜像对称
			}
			queue.add(A.left);
			queue.add(B.right);
			queue.add(A.right);
			queue.add(B.left);
		}
		
		return true;
	}
}
