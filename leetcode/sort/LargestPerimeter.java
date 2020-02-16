package leetcode.sort;

/*
 *	2019-11-19
 *	# 976. 三角形的最大周长
 */
public class LargestPerimeter {
	
	public int largestPerimeter(int[] A) {
        sort(A); // 先利用冒泡排序法对数组进行排序
        int len = A.length;
        for(int i=len-1;i>1;i--){ // 从最大的三个元素开始依次往较小的元素查找
            if(A[i]<(A[i-1]+A[i-2])){
                return (A[i]+A[i-1]+A[i-2]); 
            }
        }
        return 0;
    }

	/*
	 *	需要注意的是，冒泡排序的时间复杂度为O(N^2)
	 */
    private void sort(int[] array){
        int len = array.length;
        for(int i=1;i<len;i++){
            for(int j=0;j<len-i;j++){
                if(array[j+1]<array[j]){
                    exch(array,j,j+1);
                }
            }
        }
    }

    private void exch(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
