package leetcode.divide_and_conquer.Q53_maximum_subarray;
/**
 * LeetCode 53.最大子序和
 * Q：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @date 2020-02-24
 * @author Merlin
 */
public class SolutionA {
	/*
	 * 对测试用例的输出结果：4
	 * 说明此算法错误！原因在于算法在左右端分别取值过程中忽视了连续性这一要求
	 */
	public int maxSubArray(int[] nums) {
        // 分治算法，参考二分查找算法，将数组划分为两个小数组，
        // 分别求解小数组的最大和，随后结合两个最大和即可求出
        // nums的最大和。
        // 值得注意的是，对数组不断划分，直至小数组仅含两个元素。
        // 此时，该两个元素的最大和的规则是：
        // 1.对于左端数组，若左边值加右边值大于右边值，取二者和；否则仅取右边值。
        // 2.对于右端数组，取二者和。
        int mid = (nums.length-1)>>1;
        return leftDevide(nums, 0, mid)+rightDevide(nums, mid+1, nums.length-1);
    }

    // 实现左端数组的分治算法
    private int leftDevide(int[] nums, int lo, int hi){
        if(hi==lo){
            // 仅有一个元素
            return nums[lo];
        }
        if(hi-lo==1){
            // 有二个元素时，选择值
            if(nums[lo]+nums[hi]>nums[hi]){
                return (nums[lo]+nums[hi]);
            }else{
                return nums[hi];
            }
        }
        int mid = (hi+lo)>>1;
        return leftDevide(nums, lo, mid)+rightDevide(nums, mid+1, hi);
    }

    // 实现右端数组的分治算法
    private int rightDevide(int[] nums, int lo, int hi){
        if(hi==lo){
            // 仅有一个元素
            return nums[hi];
        }
        if(hi-lo==1){
            // 一个或二个元素时，选择值
        	if(nums[lo]+nums[hi]>nums[lo]){
        		return (nums[lo]+nums[hi]);
            }else{
                return nums[lo];
            }
        }
        int mid = (hi+lo)>>1;
        return leftDevide(nums, lo, mid)+rightDevide(nums, mid+1, hi);
    }
}
