package algorithms.search.red_black_bst;

/**
 * @date 2019-12-03
 * @author Merlin
 *	红黑树的实现
 */
@SuppressWarnings("all")
public class RedBlackBST <Key extends Comparable<Key>, Value>{
	
	private static final boolean RED = true; // 红色链接，对应的变量为true
	private static final boolean BLACK = false; // 黑色链接或空链接，对应的变量为false
	
	private Node root; // 根结点
	
	// 结点内部类
	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int N;
		private boolean color; // 指向该结点链接的颜色
		
		public Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	// 判断结点颜色，或者说是判断指向该结点链接的颜色
	private boolean isRed(Node node) {
		if(node==null) {
			return false;
		}
		return node.color == RED;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		if(node==null) {
			return 0;
		}
		return node.N;
	}
	
	// 左旋转
	private Node rotateLeft(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		x.color = node.color; // 指向node结点的链接，可左可右，可红可黑
		node.color = RED;
		x.N = node.N;
		node.N = size(node.left)+size(node.right)+1;
		return x;
	}
	
	// 右旋转
	private Node rotateRight(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = node.color; // 指向node结点的链接，可左可右，可红可黑
		node.color = RED;
		x.N = node.N;
		node.N = size(node.left)+size(node.right)+1;
		return x;
	}
	
	// 颜色转换：当某结点的两个子结点颜色均为红色时，将子结点颜色均转换为黑色，父结点转换为红色
	// 分解4-结点
	private void flipColor(Node node) {
		node.left.color = BLACK;
		node.right.color = BLACK;
		node.color = RED;
	}
	
	// 插入节点
	public void put(Key key, Value val) {
		root = putValue(root, key, val);
		root.color = BLACK; // 根结点必须为黑色
	}
	
	private Node putValue(Node node, Key key, Value val) {
		if(node==null) {
			return new Node(key, val, 1, RED); // 插入的新结点，默认颜色为RED
		}
		
		int cmp = key.compareTo(node.key);
		if(cmp < 0) {
			return putValue(node.left, key, val);
		}else if(cmp > 0) {
			return putValue(node.right, key, val);
		}else {
			node.val = val; // 命中，更新值
		}
		
		// 平衡红黑树
		if(isRed(node.right) && !isRed(node.left)) {
			rotateLeft(node); // 右子结点为红色、左子结点为黑色，进行左旋转
		}
		if(isRed(node.left) && isRed(node.left.left)) {
			rotateRight(node); // 连续两条左链接为红色，进行右旋转
		}
		if(isRed(node.left) && isRed(node.right)) {
			flipColor(node); // 左右子结点均为红色，进行颜色转换
		}
		
		node.N = size(node.left)+size(node.right)+1; // 更新结点计数器
		return node;
	}
	
}
