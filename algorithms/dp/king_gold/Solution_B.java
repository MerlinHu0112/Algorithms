package algorithms.dp.king_gold;

import java.util.HashMap;

/*
 *	国王与金矿问题，解法二：备忘录算法
 */
@SuppressWarnings("all")
public class Solution_B {
	public static void main(String[] args) {
	    int[] gold = new int[]{350, 400, 500, 200, 300};
	    int[] goldPerson = new int[]{3, 5, 5, 3, 4};
	    System.out.println(getMaxGold(5, 10, gold, goldPerson, new HashMap<Solution_B.KeyObject, Integer>()));
	}
	
	private static int getMaxGold(int n, int w, int[] g, int[] p, HashMap<KeyObject, Integer> map){
	    if(n<=0 || w<=0 || g==null || p==null){
	        return 0;
	    }
	    if(n==1 && w<p[0]){
	        return 0;
	    }
	    if(n==1 && w>=p[0]){
	        return g[0];
	    }
	    
	    KeyObject a_obj = new KeyObject(n-1, w);
	    int a = 0;
	    if(map.containsKey(a_obj)) {
	    	a = map.get(a_obj);
	    }else {
	    	a = getMaxGold(n-1, w, g, p, map);
	    	map.put(a_obj, a);
	    }
	    
	    if(w<p[n-1]) {
	    	return a;
	    }
	    
	    KeyObject b_obj = new KeyObject(n-1, w-p[n-1]);
	    int b = 0;
	    if(map.containsKey(b_obj)) {
	    	b = map.get(b_obj) + g[n-1];
	    }else {
	    	b = getMaxGold(n-1, w-p[n-1], g, p, map);
	    	map.put(b_obj, b);
	    	b += g[n-1];
	    }
	    
		return Math.max(a, b);   
	}
	
	// 内部类用于HashMap中的Key
	private static class KeyObject{
		private int n;
		private int w;
		
		public KeyObject(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}
}
