package cxydmmszn.tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 二叉树节点间的最大距离
 * @author Merlin
 * @date 2020-03-26
 */
public class SolutionB {
    
	static int maxDist = Integer.MIN_VALUE; // 最大长度
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine().split(" "); // 首行数据丢弃
        TreeNode root = createTree(reader); // 创建树，形参为输入流对象
        getMaxDist(root);
        System.out.println(maxDist+1);
    }
     
    public static int getMaxDist(TreeNode root){
        if(root==null){
            return 0;
        }
        // 左子树不为空，求左子树的maxDist
        if(root.left!=null){
            root.leftLen = getMaxDist(root.left)+1;
        }
        // 右子树不为空，求右子树的maxDist
        if(root.right!=null){
            root.rightLen = getMaxDist(root.right)+1;
        }
         
        maxDist = Math.max(maxDist, root.leftLen + root.rightLen);
        return root.leftLen >= root.rightLen ? root.leftLen : root.rightLen;
    }
     
    // 根据输入数据，构建树
    public static TreeNode createTree(BufferedReader reader) throws IOException {
        int[] vals = transferToInt(reader.readLine());
        TreeNode root = new TreeNode(vals[0]); // 根节点
        if(vals[1]!=0){
            root.left = createTree(reader); // 递归构造左子树
        }
        if(vals[2]!=0){
            root.right = createTree(reader); // 递归构造右子树
        }
        return root;
    }
     
    public static int[] transferToInt(String str){
        String[] string = str.split(" ");
        int[] arr = new int[string.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(string[i]);
        }
        return arr;
    }
     
    // 树节点
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int leftLen; // 左子树最大长度
        int rightLen; // 右子树最大长度
        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
            leftLen = 0;
            rightLen = 0;
        }
    }
}
