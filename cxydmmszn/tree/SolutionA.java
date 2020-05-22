package cxydmmszn.tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 * 第一行输入两个整数 n 和 root，n 表示二叉树的总节点个数，root 表示二叉树的根节点。
 * 以下 n 行每行三个整数 fa，lch，rch，表示 fa 的左儿子为 lch，右儿子为 rch。(如果 lch 为 0 则表示 fa 没有左儿子，rch同理)
 * @author Merlin
 * @date 2020-03-26
 * 参考他人的解法
 */
public class SolutionA {
	
	public static void main(String[] args) throws IOException {
		// 使用输入流接收输入
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 将第一次换行符前的所有输入以空格分开，并保存成字符串的形式
		reader.readLine().split(" ");
		// 创建树，参数为BufferedReader对象
		TreeNode root = createTree(reader);
		
		// 结果输出流，提高效率
		StringBuffer sb = new StringBuffer();
		
		// 先序遍历
		preOrder(root, sb);
		System.out.println(sb.substring(0, sb.length()-1));
		sb.delete(0, sb.length());
		
		// 中序遍历
		inOrder(root, sb);
		System.out.println(sb.substring(0, sb.length()-1));
		sb.delete(0, sb.length());
		
		// 后序遍历
		posOrder(root, sb);
		System.out.println(sb.substring(0, sb.length()-1));
		sb.delete(0, sb.length());
	}
	
	public static void preOrder(TreeNode root, StringBuffer sb) {
		if(root==null) {
			return;
		}
		sb.append(root.val+" ");
		if(root.left!=null) {
			preOrder(root.left, sb);
		}
		if(root.right!=null) {
			preOrder(root.right, sb);
		}
	}
	
	public static void inOrder(TreeNode root, StringBuffer sb) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			inOrder(root.left, sb);
		}
		sb.append(root.val+" ");
		if(root.right!=null) {
			inOrder(root.right, sb);
		}
	}
	
	public static void posOrder(TreeNode root, StringBuffer sb) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			posOrder(root.left, sb);
		}
		if(root.right!=null) {
			posOrder(root.right, sb);
		}
		sb.append(root.val+" ");
	}
	
	/*
	 * 创建二叉树的核心在于：递归地创建子树
	 */
	public static TreeNode createTree(BufferedReader reader) throws IOException {
		// 将输入流的每一行转换成整数
		int[] eles = transferToInt(reader.readLine());
		// 根结点
		TreeNode root = new TreeNode(eles[0]);
		// 通过递归构建二叉树
		if(eles[1]!=0) {
			// 左孩子
			root.left = createTree(reader);
		}
		if(eles[2]!=0) {
			// 右孩子
			root.right = createTree(reader);
		}
		return root;
	}
	
	public static int[] transferToInt(String str) {
		String[] temp = str.split(" ");
		int[] result = new int[temp.length];
		for(int i=0; i<result.length; i++) {
			result[i] = Integer.parseInt(temp[i]);
		}
		return result;
	}
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
}
