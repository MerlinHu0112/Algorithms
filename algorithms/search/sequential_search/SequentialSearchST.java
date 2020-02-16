package algorithms.search.sequential_search;

import edu.princeton.cs.algs4.Queue;

/*
 *	2019-11-05
 *	基于无序链表的顺序查找符号表的实现
 */
public class SequentialSearchST<Key, Value> implements SimpleST<Key, Value> {

	private Node first; // 首结点
	private int count; // 符号表计数器（初始值为 0）
	
	public SequentialSearchST() {}
	
	// 私有的内部类Node，用于结点存储键值对
	private class Node {
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	/* 
	 *	Value get(Key key)方法：顺序查找链表，匹配给定的键并返回对应的值，
	 *	若无则返回null
	 */
	public Value get(Key key) {
		if (key==null) {
			throw new RuntimeException("参数key不可为空！");
		}
		for (Node x = first; x!=null; x = x.next) {
			if (key.equals(x.key)) {
				return x.val;
			}
		}
		return null;
	}
	
	/*
	 *	void put(Key key, Value val)方法：顺序查找链表，匹配给定的键并
	 *	更新对应的值，若无对应结点则新建结点并存入相应的键值对
	 */
	public void put(Key key, Value val) {
		if (key==null) {
			throw new RuntimeException("参数key不可为空！");
		}
		if (val == null) {
			delete(key);
			return;
		}
		for (Node x = first; x!=null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		// 新建结点，从"头"插入新的结点
		first = new Node(key, val, first); // 注意形参"first"
		count++;
	}
	
	/*
	 *	void delete(Key key)方法：从表中删除键key及对应的值
	 */
	/*public void delete(Key key) {
		if (key==null) {
			throw new RuntimeException("参数key不可为空！");
		}
		if (isEmpty()) {
			throw new RuntimeException("符号表为空，无法执行删除键值对操作！");
		}
		Node pNode = first;
		// 若key恰好在首结点
		if (key.equals(first.key)) {
			first = pNode.next;
		}else {
			Node qNode = pNode;
			while (!key.equals(pNode.key)) {
				qNode = pNode; // 指向前驱结点
				pNode = pNode.next;
				if (pNode == null) {
					throw new RuntimeException("待删除的键不存在，请检查！");
				}
			}
			qNode.next = pNode.next;
		}
		pNode = null; // 释放内存
	}*/
	public void delete(Key key) {
		if (key==null) {
			throw new RuntimeException("参数key不可为空！");
		}
		first = delete(first, key);
	}
	
	private Node delete(Node pNode, Key key) {
		if (pNode==null) {
			return null; // 符号表为空
		}
		if (key.equals(pNode.key)) {
			count--;
			return pNode.next;
		}
		pNode.next = delete(pNode.next, key); // 递归调用
		return pNode;
	}

	/*
	 *	boolean contains(Key key)方法：键key在表中是否存在对应的值
	 */
	public boolean contains(Key key) {
		if (key==null) {
			throw new RuntimeException("参数key不可为空！");
		}
		return get(key)!=null;
	}
	
	/*
	 *	boolean isEmpty()方法：判断符号表是否为空
	 */
	public boolean isEmpty() {
		return count==0;
	}

	/*
	 *	int size()方法：返回表的大小（即键值对数量）
	 */
	public int size() {
		return count;
	}

	/*
	 *	Iterable<Key> keys()方法：返回表中所有键的集合
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
	}

}
