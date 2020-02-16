package leetcode.sort;

/**
 * @date 2019-12-02
 * @author Merlin
 *	题目：给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *		  使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 *
 */
public class SortColors {

	/*
	 *	解法一：使用计数排序，遍历一次数组，分别得出0，1和2的数量，再分别覆写原数组
	 */
	/*
	public void sortColors(int[] nums) {
		int red_len = 0;
		int white_len = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				red_len++;
			}else if(nums[i]==1) {
				white_len++;
			}
		}
		
		int i=0;
		while(i<red_len) {
			nums[i] = 0;
			i++;
		}
		while(i<(white_len+red_len)) {
			nums[i] = 1;
			i++;
		}
		while(i<nums.length) {
			nums[i] = 2;
			i++;
		}
	}
	*/
	
	
	/*
	 *	解法二：设置指针p0、p2、curr，分别指向0的右边界、2的左边界和当前元素，
	 *		      当前元素为0时，curr与p0指向的元素互换，curr和p0分别右移一位；
	 *		      当前元素为1时，curr右移一位；
	 *		      当前元素为2时，curr与p2指向的元素互换，p2左移一位，需注意，curr必须再检查一次，因为刚互换的至curr的可能是0
	 */
	public void sortColors(int[] nums) {
		int curr = 0;
		int p0 = 0;
		int p2 = nums.length-1;
		while(curr <= p2) {
			if (nums[curr]==0) {
				swap(nums,curr++, p0++);
			}else if(nums[curr]==2) {
				swap(nums, curr, p2--);
			}else {
				curr++;
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
