package leetcode.tree.symmetric_binary_tree;
import leetcode.TreeNode;
/**
 * LeetCode #101.对称二叉树
 * Q：给定一个二叉树，检查它是否是镜像对称的。
 * @date 2020-02-19
 * @author Merlin
 */
public class SolutionB {
	/*
	 * SolutionA为最开始想到的方法，但算法步骤较多，导致运行超时
	 * SolutioB：以树深度为2的满二叉数为例，该二叉树有两个显著特征，
	 * 1、根结点为同一个；
	 * 2、根结点的左孩子结点与右孩子结点元素值相同。
	 * 
	 * 镜像对称的二叉树应该满足下列描述：
	 * 1、根结点（A、B）值相同；
	 * 2、结点A的左子树与结点B的右子树镜像对称；
	 * 3、结点A的右子树与结点B的左子树镜像对称。
	 * 
	 * 输出结果：通过
	 */
	public boolean isSymmetric(TreeNode root) {
		return recursive(root, root);
	}
	
	/*
	 * 递归函数，判断二叉树A与二叉树B是否为镜像对称的两棵树
	 * A、B分别为两棵二叉树的根结点
	 */
	private boolean recursive(TreeNode A, TreeNode B) {
		// 两棵树根结点同时为空，满足镜像对称
		if(A==null && B==null) {
			return true;
		}
		
		// 两棵树根结点不同时为空，一定满足镜像对称
		// 注意：前面的if语句已经排除了A、B同时为空，所以A为null，B一定不为null
		if(A==null || B==null) { 
			return false;
		}
		
		// 以下为判断两棵二叉树是否满足上述关于镜像对称的描述
		// 简化之前的if嵌套语句
		return ((A.val==B.val)&&(recursive(A.left, B.right))&&(recursive(A.right, B.left)));
		
		/*
		if(A.val==B.val) { // 1、根结点（A、B）值相同
			if(recursive(A.left, B.right)) { // 2、结点A的左子树与结点B的右子树镜像对称
				if(recursive(A.right, B.left )) { // 3、结点A的右子树与结点B的左子树镜像对称
					return true;
				}
			}
		}
		return false;
		*/
	}
}
