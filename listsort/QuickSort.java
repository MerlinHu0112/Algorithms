package listsort;

/**
 * @ClassName QuickSort
 * @Description 数组和单链表的快速排序
 * @Author Merlin
 * @Date 2020/4/21 16:33
 * @Version 1.0
 */
public class QuickSort implements SortMethod {

    @Override
    public int[] sort(int[] arr) {
        if(arr==null || arr.length==0)
            return arr;
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void quickSort(int[] arr, int lo, int hi){
        if(lo > hi)
            return;

        int pivot = arr[lo];
        int i = lo, j = hi;
        while(i != j){
            while(arr[j] >= pivot && j > i){
                j--;
            }
            while(arr[i] <= pivot && i < j){
                i++;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[lo] = arr[i];
        arr[i] = pivot;
        quickSort(arr, lo, i-1);
        quickSort(arr, i+1, hi);
    }


    @Override
    public ListNode sort(ListNode head) {
        return null;
    }
}
