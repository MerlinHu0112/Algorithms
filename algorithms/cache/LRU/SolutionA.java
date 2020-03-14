package algorithms.cache.LRU;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * LRU（最近最久未使用）缓存算法。
 *	基于LinkedHashMap（有序字典）的实现
 * @author Merlin
 * @date 2020-03-11
 */
@SuppressWarnings("all")
public class SolutionA {
	
	private LinkedHashMap<Integer, Integer> map;
	private int MAX_CACHE_SIZE;

    // LinkedHashMap默认按照插入键值对的顺序记录双链表，同时也提供
    // 一个特殊的构造函数。通过该构造函数，很容易完成LRU缓存功能。
    // initialCapacity -- 初始容量
    // loadFactor -- 加载因子
    // accessOrder -- true：按访问顺序；false：按插入顺序。
    public SolutionA(int capacity) {
    	MAX_CACHE_SIZE = capacity;
    	map = new LinkedHashMap<Integer, Integer>((int) Math.ceil(capacity / 0.75f) + 1, 0.75f, true){
    		@Override
    		protected boolean removeEldestEntry(Map.Entry eldest) {
    			return size() > MAX_CACHE_SIZE;
    		}
    	};
    }
    
    public int get(int key) {
    	Integer value = map.get(key);
    	return value == null ? -1 : value;
    }
    
    public void put(int key, int value) {
    	map.put(key, value);
    }
}
