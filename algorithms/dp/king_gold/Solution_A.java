package algorithms.dp.king_gold;
/*
 *	国王与金矿问题，解法一：递归
 */
public class Solution_A {
	
	public static void main(String[] args) {
	    int[] gold = new int[]{350, 400, 500, 200, 300};
	    int[] goldPerson = new int[]{3, 5, 5, 3, 4};
	    System.out.println(getMaxGold(5, 10, gold, goldPerson));
	}
	
	private static int getMaxGold(int n, int w, int[] g, int[] p){
	    if(n<=0 || w<=0 || g==null || p==null){
	        return 0;
	    }
	    if(n==1 && w<p[0]){
	        return 0;
	    }
	    if(n==1 && w>=p[0]){
	        return g[0];
	    }
	    
	    int a = getMaxGold(n-1, w, g, p);
	    if(w<p[n-1]){
	        return a;
	    }
	    int b = getMaxGold(n-1, w-p[n-1], g, p) + g[n-1];
	    return Math.max(a, b);
	}
}
