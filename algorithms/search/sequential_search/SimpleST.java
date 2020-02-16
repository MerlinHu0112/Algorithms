package algorithms.search.sequential_search;
/*
 *	2019-11-05
 *	简单符号表的接口
 */
public interface SimpleST<Key, Value> {
	public void put(Key key, Value val); // 将键值对存入表中，若值为空则将键key从表中删除
	public Value get(Key key); // 获取键key对应的值，若键key不存在则返回null
	public void delete(Key key); // 从表中删除键key及对应的值
	public boolean contains(Key key); // 键key在表中是否存在对应的值
	public boolean isEmpty(); // 表是否为空
	public int size(); // 返回表的大小（即键值对数量）
	Iterable<Key> keys(); // 返回表中所有键的集合
}
