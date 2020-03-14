package algorithms.cache.LRU;
import java.util.HashMap;
/**
 * LRU（最近最久未使用）缓存算法。
 *	基于哈希表+双向链表的实现（自行实现LinkedHashMap）
 * @author Merlin
 * @date 2020-03-12
 */
public class SolutionB {
	
	// 双向链表的结点
	private class Node{
		int key;
		int value;
		Node prev;
		Node next;
	}
	private Node head; // 辅助的头指针
	private Node tail; // 辅助的尾指针
	
	// 在头部插入结点
	private void insertHeadNode(Node node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	// 移除尾结点
	private Node removeTailNode() {
		Node target = tail.prev;
		removeNode(target);
		// 返回被移除的结点指针，是为了再移除尾结点后，
		// 从哈希表中删除对应的记录。
		return target;
	}
	
	// 移除结点
	private void removeNode(Node node) {
		Node pNode = node.prev;
		Node qNode = node.next;
		pNode.next = qNode;
		qNode.prev = pNode;
	}
	
	// 移动结点至头结点位置
	private void moveToHead(Node node) {
		// 先移除，再插入
		removeNode(node);
		insertHeadNode(node);
	}
	
	private HashMap<Integer, Node> cache;
	private final float DEFAULT_LOAD_FACTOR = 0.75f; // 加载因子
	private int MAX_CACHE_SIZE; // 缓存容量;
	
    public SolutionB(int capacity) {
    	int initialCapacity = (int) Math.ceil(capacity / DEFAULT_LOAD_FACTOR) + 1; // 哈希表初始容量
    	cache = new HashMap<>(initialCapacity, DEFAULT_LOAD_FACTOR);
    	MAX_CACHE_SIZE = capacity;
    	// 初始化头尾指针
    	head = new Node();
    	tail = new Node();
    	head.next = tail;
    	tail.prev = head;
    }
    
    public int get(int key) {
    	Node node = cache.get(key);
    	if(node==null) {
    		return -1;
    	}
    	moveToHead(node); // 更新访问记录
    	return node.value;
    }
    
    public void put(int key, int value) {
    	Node node = null;
    	// 键已存在
    	if(cache.containsKey(key)) {
    		node = cache.get(key);
    		node.value = value;
    		moveToHead(node);
    		return;
    	}
    	// 键不存在
    	node = new Node();
    	node.key = key;
    	node.value = value;
    	insertHeadNode(node); // 插入头结点
    	cache.put(key, node);
    	// 还需判断哈希表容量是否已超过缓存容量
    	if(cache.size() > MAX_CACHE_SIZE) {
    		Node target = removeTailNode(); // 移除尾结点
    		cache.remove(target.key);
    	}
    	return;
    }
}
