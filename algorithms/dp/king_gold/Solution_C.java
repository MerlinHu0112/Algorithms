package algorithms.dp.king_gold;
/*
 *	国王与金矿问题，解法三：动态规划算法
 */
public class Solution_C {
	
	public static void main(String[] args) {
	    int[] gold = new int[]{350, 400, 500, 200, 300};
	    int[] goldPerson = new int[]{3, 5, 5, 3, 4};
	    System.out.println(getMaxGold(5, 10, gold, goldPerson));
	}
	
	private static int getMaxGold(int n, int w, int[] g, int[] p){
	    if(n<=0 || w<=0 || g==null || p==null){
	        return 0;
	    }
	   
	    int[] preResult = new int[w+1]; // w+1列，保存上一行数据
	    int[] result = new int[w+1];
	    
	    // 填充边界
	    for(int j=0;j<=w;j++) {
	    	if(j<p[0]) {
	    		preResult[j] = 0; // 当金矿数为1，但工人总数无法满足开采要求时
	    	}else {
	    		preResult[j] = g[0]; // 金矿数为1，且工人总数满足要求
	    	}
	    }
	    
	    if(n==1) {
	    	return preResult[w];
	    }
	    
	    // 状态转移方程
	    // 外循环中，i为当前金矿索引；内循环中，j为工人数
	    for(int i=1;i<n;i++) {
	    	for(int j=0;j<=w;j++) {
	    		if(j<p[i]) {
	    			// 若j个工人不能满足开采第i+1座金矿所需的工人数
	    			result[j] = preResult[j];
	    		}else {
	    			// 若第i+1座金矿有足够的人工开挖，则j个工人开挖i+1座金矿
	    			result[j] = Math.max(preResult[j], preResult[j-p[i]]+g[i]);
	    		}
	    	}
	    	// 更新子状态
		    for(int j=0;j<=w;j++) {
		    	preResult[j] = result[j];
		    }
	    }
	    
	    return result[w];
	}
}
