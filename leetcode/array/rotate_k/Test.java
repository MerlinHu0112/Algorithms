package leetcode.array.rotate_k;

public class Test {
	public static void main(String[] args) {
		int[] arrayA = {1, 2, 3, 4, 5, 6, 7};
		int[] arrayB = {1, 2, 3, 4, 5, 6};
		SolutionA solA = new SolutionA();
		solA.rotate(arrayA, 3);
		print(arrayA);
		solA.rotate(arrayB, 2);
		print(arrayB);
	}
	
	private static void print(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
