package algorithms.search.binary_search;

import java.util.NoSuchElementException;

/*
 *	2019-11-06
 *	基于有序数组的二分查找
 */
@SuppressWarnings("all")
public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] vals;
	private int length;
	private int ST_Max_Length;
	
	public BinarySearchST(int ST_capacity) { // ST_capacity:数组的容量
		// 初始化两个并行的数组
		keys = (Key[]) new Comparable[ST_capacity];
		vals = (Value[]) new Object[ST_capacity];
		ST_Max_Length = ST_capacity;
	}

	/* 
	 *	Value get(Key key)方法：二分查找键key并返回对应的值，若无则返回null
	 */
	public Value get(Key key) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不可为空！");
		}
		if (isEmpty()) {
			return null; // 符号表为空，返回null
		}
		int i = binarySearch(key); // 调用rank()方法，返回键的位置
		if (i<length && key.compareTo(keys[i])==0) {
			return vals[i];
		}else {
			return null;
		}
	}
	
	/*
	 *	void put(Key key, Value val)方法：二分查找符号表，匹配给定的键并
	 *	更新对应的值；若无对应键key，则按照key的次序插入新的键值对，其后的键
	 *	值对（若有）均往后移动一位
	 */
	public void put(Key key, Value val) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不可为空！");
		}
		int i = binarySearch(key);
		if (i<length && key.compareTo(keys[i])==0) {
			// 已存在键key，更新value
			vals[i] = val;
			return;
		}else {
			if (length >= ST_Max_Length) {
				throw new RuntimeException("符号表已满！");
			}
			// 不存在键key，按序插入新的键值对
			for (int j = length; j>i; j--) { // 插入位置后的所有键值对均向后移动一位
				keys[j] = keys[j-1];
				vals[j] = vals[j-1];
			}
			// 插入新的键值对
			keys[i] = key;
			vals[i] = val;
			length++;
			return;
		}
	}
	
	/*
	 *	int binarySearch(Key key)方法：二分查找，若表中存在键key，则返回其位置；
	 *	若不存在，则返回小于该key的键的数量
	 */
	private int binarySearch(Key key) {
		// 调用rank(Key key, int lo, int hi)方法，其中lo初始为0
		return binarySearch(key, 0, length-1);
	}
	
	// 递归的二分查找
	private int binarySearch(Key key, int lo, int hi) {
		if (hi<lo) {
			return lo;
		}
		int mid = lo + (hi-lo)/2;
		int flag = key.compareTo(keys[mid]);
		if (flag < 0) {
			return binarySearch(key, lo, mid-1);
		}else if(flag > 0) {
			return binarySearch(key, mid+1, hi);
		}else {
			return mid;
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
		return length==0;
	}

	/*
	 *	int size()方法：返回表的大小（即键值对数量）
	 */
	public int size() {
		return length;
	}
	
	/*
	 * Key min()方法：返回最小的键
	 */
	public Key min() {
		if (isEmpty()) {
			throw new NoSuchElementException("符号表为空！");
		}
		return keys[0];
	}
	
	/*
	 *	Key max()方法：返回最大的键
	 */
	public Key max() {
		if (isEmpty()) {
			throw new NoSuchElementException("符号表为空！");
		}
		return keys[length-1];
	}
	
	/*
	 *	Key floor(Key key)方法：返回小于或等于key的最大键
	 */
	public Key floor(Key key) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不可为空！");
		}
		int i = binarySearch(key);
		if (i<length && key.compareTo(keys[i])==0) {
			// 若key已存在，则返回该key
			return key; 
		}else if (i==0) {
			return null; // 待查的key小于keys中的所有key
		}else {
			return keys[i-1];
		}
	}
	
	/*
	 *	Key ceiling(Key key)方法：返回大于或等于key的最小键
	 */
	public Key ceiling(Key key) {
		if (key==null) {
			throw new IllegalArgumentException("参数key不可为空！");
		}
		int i = binarySearch(key);
		if (i==length) {
			return null; //待查的key大于keys中的所有key，返回null
		}else {
			return keys[i];
		}
	}

}
