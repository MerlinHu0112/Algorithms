package algorithms.search.binary_search_tree;

import javax.print.attribute.Size2DSyntax;
import javax.security.auth.kerberos.KerberosTicket;

/*
 *	2019-11-08
 *	基于二叉查找树的符号表实现
 */
@SuppressWarnings("all")
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private BinaryNode root; // 根结点
	
	// 二叉查找树的结点类
	private class BinaryNode {
		private Key key;
		private Value val;
		private BinaryNode left;
		private BinaryNode right;
		private int N; // 以该结点为根的子树中结点的总数目
		
		public BinaryNode(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	/*
	 *	Value get(Key key)
	 *	查找算法的递归实现：命中时，返回键对应的值；未命中，返回null
	 */
	public Value get(Key key) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不能为空！");
		}
		return getValue(root, key);
	}
	
	private Value getValue(BinaryNode node, Key key) {
		if (node==null) { // 结点为null时，返回null
			return null;
		}
		int flag = key.compareTo(node.key);
		if (flag < 0) {
			return getValue(node.left, key); // key小于结点的key，则递归查找左子树
		}else if (flag > 0) {
			return getValue(node.right, key); // key大于结点的key，则递归查找右子树
		}else {
			return node.val; // 命中，返回对应的值
		}
	}
	
	/*
	 *	void put(Key key, Value val)
	 *	插入算法的递归实现：命中时，更新值；
	 *	未命中时，递归查找返回null，此时在相应位置新建结点。
	 *	新建结点后，需要从新建结点开始往上更新链接关系，并更新结点计数器
	 */
	public void put(Key key, Value val) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不能为空！");
		}
		if (val==null) {
			throw new IllegalArgumentException("参数value不能为空！");
		}
		root = putValue(root, key, val);
	}
	
	private BinaryNode putValue(BinaryNode node, Key key, Value val) {
		if (node==null) {
			// 未命中，新建结点
			return new BinaryNode(key, val, 1);
		}
		int flag = key.compareTo(node.key);
		if (flag < 0) {
			node.left = putValue(node.left, key, val);
		}else if (flag > 0) {
			node.right = putValue(node.right, key, val);
		}else {
			node.val = val; // 命中，更新值
		}
		node.N = size(node.left) + size(node.right) + 1; // 更新结点计数器
		return node;
	}
	
	/*
	 *	int size():返回二叉查找树的结点总数
	 */
	public int size() {
		return size(root);
	}
	
	/*
	 *	int size(BinaryNode node)：返回根结点为node的子树的结点总数
	 */
	private int size(BinaryNode node) {
		if (node==null) {
			return 0;
		}else {
			return node.N;
		}
	}
	
	/*
	 *	boolean contains(Key key)方法：键key在表中是否存在对应的值
	 */
	public boolean contains(Key key) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不可为空！");
		}
		return get(key)!=null;
	}
	
	/*
	 *	boolean isEmpty()方法：判断符号表是否为空
	 */
	public boolean isEmpty() {
		return size()==0;
	}

	
	/*
	 *	Key min()：返回最小的键
	 */
	public Key min() {
		return min(root).key;
	}
	
	private BinaryNode min(BinaryNode node) {
		if(node.left==null) {
			return node;
		}else {
			return min(node.left);
		}
	}
	
	/*
	 *	Key max()：返回最小的键
	 */
	public Key max() {
		return max(root).key;
	}
	
	private BinaryNode max(BinaryNode node) {
		if(node.right==null) {
			return node;
		}else {
			return max(node.right);
		}
	}
	
	/*
	 *	Key floor(Key key)：向上取整，返回小于或等于参数key的最大键
	 */
	public Key floor(Key key) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不能为空！");
		}
		BinaryNode node = floor(root, key);
		if (node==null) {
			return null;
		}
		return node.key;
	}
	
	private BinaryNode floor(BinaryNode node, Key key) {
		if(node==null) {
			return null;
		}
		int flag = key.compareTo(node.key);
		if(flag==0) {
			return node; // 恰好命中
		}else if(flag < 0) {
			return floor(node.left, key); // 递归进入左子树查找
		}else {
			// 递归进入右子树查找，若有则返回该节点，若无则返回根结点
			BinaryNode rightNode = floor(node.right, key);
			if (rightNode==null) {
				return node;
			}else {
				return rightNode;
			}
		}
	}
	
	/*
	 *	Key ceiling(Key key)：向下取整，返回大于或等于参数key的最小键
	 */
	public Key ceiling(Key key) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不能为空！");
		}
		BinaryNode node = ceiling(root, key);
		if (node==null) {
			return null;
		}
		return node.key;
	}
	
	private BinaryNode ceiling(BinaryNode node, Key key) {
		if(node==null) {
			return null;
		}
		int flag = key.compareTo(node.key);
		if(flag==0) {
			return node; // 恰好命中
		}else if(flag > 0) {
			return ceiling(node.right, key); // 递归进入右子树查找
		}else {
			// 递归进入左子树查找，若有则返回该节点，若无则返回根结点
			BinaryNode leftNode = ceiling(node.left, key);
			if (leftNode==null) {
				return node;
			}else {
				return leftNode;
			}
		}
	}
	
	/*
	 *	select(int k):寻找排名为k的键
	 */
	public Key select(int k) {
		if(k<=0 || k>size()) {
			throw new IllegalArgumentException("名次k不合法！");
		}
		return select(root, k).key;
	}
	
	private BinaryNode select(BinaryNode node, int k) {
		int t = size(node.left)+1; // 获取父结点的排名
		if(t>k) {
			return select(node.left, k); // 左子树结点数大于k，则递归进入左子树查找
		}else if(t<k) {
			return select(node.right, k-t); // 左子树结点数已不足，则进入右子树查找
											  // 注意，进入右子树后，k值需要“剔除”父结点及左子树所有结点
		}else {
			return node; // 即为父结点
		}
	}
	
	/*
	 *	rank(Key key):返回指定键key的排名（键key应存在）
	 */
	public int rank(Key key) {
		if(key==null) {
			throw new IllegalArgumentException("名次key不为空！");
		}
		if(!contains(key)) {
			throw new RuntimeException("指定的key不存在");
		}
		return rank(root, key);
	}
	
	private int rank(BinaryNode node, Key key) {
		int flag = key.compareTo(node.key);
		if(flag<0) {
			return rank(node.left, key);
		}else if(flag>0) {
			return rank(node.right, key)+size(node.left)+1;
		}else {
			return size(node.left)+1;
		}
	}
	
	/*
	 *	deleteMin():删除最小的键
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private BinaryNode deleteMin(BinaryNode node) {
		if(node.left==null) {
			return node.right; // 将指向最小键的结点的指针修改为指向最小结点的右孩子结点
		}
		node.left = deleteMin(node.left); // 递归，至最小键结点
		node.N = size(node.left)+size(node.right)+1; // 更新结点计数器
		return node;
	}
	
	/*
	 *	deleteMax():删除最大的键
	 */
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	public BinaryNode deleteMax(BinaryNode node) {
		if(node.right==null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.N = size(node.left)+size(node.right)+1;
		return node;
	}
}
