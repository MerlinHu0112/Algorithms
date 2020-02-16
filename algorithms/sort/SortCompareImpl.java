package algorithms.sort;

public class SortCompareImpl implements SortCompare {

	@Override
	public void calculateSortMethodRunTime(SortMethod sortMethod, Integer[] array) {
		//long startTime = System.currentTimeMillis();
		long startTime = System.nanoTime();
		sortMethod.sort(array);
		//long endTime = System.currentTimeMillis();
		long endTime = System.nanoTime();
		if (SortUtil.isSorted(array)) {
			System.out.println(array.length+"个随机数排序，耗时："+((endTime-startTime)/1000000)+"毫秒;");
		}else {
			System.out.println("排序出现异常");
		}
	}

}
