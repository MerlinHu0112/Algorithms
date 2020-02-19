package leetcode.tree.symmetric_binary_tree;
import java.util.ArrayList;
import java.util.List;
import leetcode.TreeNode;
/**
 * LeetCode #101.对称二叉树
 * Q：给定一个二叉树，检查它是否是镜像对称的。
 * @date 2020-02-19
 * @author Merlin
 */
public class SolutionA {
	/*
	 * 经分析，若给定的二叉树是镜像对称的，对该二叉树进行中序遍历，
	 * 其输出结果是关于根结点元素对称。
	 * 
	 * 输出结果：超时
	 */
    public boolean isSymmetric(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrderToArray(root, list);
        return isSymmetric(list);
    }

    // 中序遍历给定的二叉树，按遍历顺序将节点元素存入List集合
    private void inOrderToArray(TreeNode node, List<Integer> list){
        if(node==null) {
        	return;
        }
        if(node.left!=null) {
        	inOrderToArray(node.left, list);
        }
        list.add(node.val);
        if(node.right!=null) {
        	inOrderToArray(node.right, list);
        }
    }
    
    // 判断转换后的List是否为对称的
    private boolean isSymmetric(List<Integer> list) {
    	if(list.isEmpty()) {
    		return true;
    	}
    	int lo = 0;
    	int hi = list.size()-1;
    	while(lo<hi) {
    		if(!((list.get(lo)).equals(list.get(hi)))){
    			break;
    		}
    	}
    	if(lo<hi) {
    		return false;
    	}
    	return true;
    }
}
