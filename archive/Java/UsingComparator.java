package syntax;

import java.util.Arrays;
import java.util.Comparator;

public class UsingComparator{

	public static int[][] customSort(int [][] array){
		if(array.length == 0 || array == null)
			return null;
		Arrays.sort(array, new Comparator<int[]>(){
			@Override
			public int compare(final int[] x, final int[] y){
				if(x[0] > y[0] ) return 1;
				else return -1;
			}
		});
		return array;
	}

	public static void printArray(int [][] array){
		for(int i=0; i<array.length; i++){
			System.out.print("[" + array[i][0] + "," + array[i][1] + "]" + " , ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int [][] intervals = {{2,6}, {8,10}, {1,3}, {15,18}};
		printArray(intervals);
		customSort(intervals);
		printArray(intervals);
	}
}