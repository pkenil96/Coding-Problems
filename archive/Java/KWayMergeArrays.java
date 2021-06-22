package careercup;

/*
Merge k sorted arrays | Set 1
Given k sorted arrays of size n each, merge them and print the sorted output.
Example:

Input:
k = 3, n = 4
arr[][] = { {1, 3, 5, 7},
{2, 4, 6, 8},
{0, 9, 10, 11}} ;
*/

public class KWayMergeArrays{
    public static int[] mergeKSortedArrays(int [][] arrays, int k, int n){
        if(arrays.length == 0 || arrays == null) return;
        
    }

    public static void main(String [] args){
        int k = 3, n = 4;
        int [][] arrays = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        int [] mergedArray = mergeKSortedArrays(arrays, k, n);        
    }
}
