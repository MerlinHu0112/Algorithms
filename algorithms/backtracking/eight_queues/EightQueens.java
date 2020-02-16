package algorithms.backtracking.eight_queues;
/**
 * 八皇后问题，基于递归的回溯思想，解决此问题
 * 2020-01-13
 * @author Merlin
 *
 */
public class EightQueens {
	
	private static int[] checkerboard = new int[8]; // 棋盘的列投影，记录每一行的皇后存放的列索引值
	private static final int len = 8; // 棋盘的行或列长度为8
	private static final int queens = 8; // 皇后数，为8
	private int total = 0; // 记录总共的解法数，对八皇后问题，应为92
	
	public EightQueens() {}
	
	/**
	 * 递归地放置皇后到第i+1行合适的位置
	 * 放置第i+1行的皇后之后，需要判断其是否与之前的皇后冲突，若无，递归进入下一行；
	 * 若产生冲突，将其往后移动一列，避免冲突
	 * 注意for循环内部是递归嵌套的，若到最后某一行皇后已无法移动，则会逐步返回上一层，直至
	 * 调整首行以实现放入所有皇后
	 * @param i 行序号，[0, 7]
	 */
	private void putQueen(int i) {
		if(i==queens) {
			total++; // 此语句执行则说明当前结果是一种可行解法，故总解法数加1
		}else {
			for(int col=0; col<len; col++) {
				checkerboard[i] = col; // 对于第i+1行，该行的皇后放在第col+1列；若if语句为false，则调整第i+1行的皇后位置
				if(check(i)) {
					putQueen(i+1); // 若检查发现，第i+1行及之前各行皇后位置均满足题意，则递归移动下一行
				}
			}
		}
	}
	
	/**
	 * 判断第i+1行放入的皇后是否与之前的皇后产生冲突
	 * @param i 行序号，[0, 7]
	 * @return
	 */
	private boolean check(int i) {
		for(int j=0; j<i; j++) {
			// j为第i+1行之前的所有行，需要逐一比较
			if(checkerboard[i]==checkerboard[j] || i-checkerboard[i]==j-checkerboard[j] ||
					i+checkerboard[i]==j+checkerboard[j]) {
				// checkerboard[i]==checkerboard[j] 判断不同行的皇后是否在同一列
				// i-checkerboard[i]==j-checkerboard[j] 判断不同行的皇后是否在左对角线上
				// i+checkerboard[i]==j+checkerboard[j] 判断不同行的皇后是否在右对角线上
				return false;
			}
		}
		return true;
	}
	
	// 辅助方法，启动putQueen
	public void run() {
		putQueen(0); // 从第1行开始，其行序号为0
	}
	
	public int getTotal() {
		return total;
	}
}
