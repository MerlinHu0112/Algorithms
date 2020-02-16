package algorithms.recursion;

import org.junit.Test;
/**
 * @date 2019-08-28
 * @author Merlin
 * Hanoi塔问题
 *
 */
public class HanoiTower {
	
	private static int i = 1;
	
	@Test
	public void runHanoiTower() {
		String A = "A"; // A柱
		String B = "B"; // B柱
		String C = "C"; // C柱
		int DiskNumber = 5; // 总的圆盘数
		moveHanoiTower(DiskNumber, A, B, C);
	}
	
	// 定义移动圆盘的规则：借助y柱，将n个圆盘从x柱移至z柱
	private void moveHanoiTower(int n, String x, String y, String z) {
		if (n==1) {
			move(n, x, z); // 若圆盘只有1个，则将其直接从x柱移至z柱
		}else {
			this.moveHanoiTower(n-1, x, z, y); // 圆盘为n(n>1)，先借助z柱将n-1个圆盘从x柱移至y柱
			move(n, x, z); // 将第n个圆盘直接从x柱移至z柱
			this.moveHanoiTower(n-1, y, x, z); // 借助x柱，将剩下的n-1个圆盘从y柱移至z柱
		}
	}
	
	// 定义移动单个圆盘的规则:将第i个圆盘直接从x柱移至z柱
	private void move(int n, String x, String z) {
		System.out.println("第"+i+"步，将第"+n+"号圆盘从"+x+"柱移动至"+z+"柱");
		i++;
	}
}
