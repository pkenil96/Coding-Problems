package leetcode;

import java.util.Arrays;

class SquaresOfSortedArrays {
    public int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0)
            return A;
        for(int i=0; i<A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}