package arrays;

class MergingSortedArrays{

	public static int [] MergingSortedArraysUtil(int [] arr1, int [] arr2){
		if(arr1.length == 0 || arr1 == null) return arr2;
		if(arr2.length == 0 || arr2 == null) return arr1;

		int [] result = new int[arr1.length+arr2.length];
		int p1 = 0, p2 = 0, k = 0, m = arr1.length, n = arr2.length;

		while(p1 < m && p2 < n ){
			if(arr1[p1] <= arr2[p2]){
				result[k++] = arr1[p1++];
			} else {
				result[k++] = arr2[p2++];
			}
		}

		// in case either of the two arrays are yet to be traversed
		while(p1 < m){
			result[k++] = arr1[p1++];
		}

		while(p2 < n){
			result[k++] = arr2[p2++];
		}
		
		return result;
	}

	public static void main(String[] args) {
		int [] arr1 = {1,4,5,7,9,14,15};
		int [] arr2 = {2,3};
		int [] sortedArray = MergingSortedArraysUtil(arr1, arr2);
		
		for(int i=0; i<sortedArray.length; i++){
			System.out.print(sortedArray[i]+"\t");
		}
		System.out.println();
	}
}
