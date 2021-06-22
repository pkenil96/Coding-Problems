#include <bits/stdc++.h>
using namespace std;

//using kadane's algorithm
int maximumSubarraySum(int* array){
	int global_max = 0, max_till_now = 0;
	int n = sizeof(array);
	
	for(int i=0; i<n; i++){
		max_till_now += array[i];
		if(max_till_now < 0)
			max_till_now = 0;
		if(max_till_now > global_max)
			global_max = max_till_now;
	}
	return global_max;
}

int main(){
	int array[] = {-2, -3, 4, -1, -2, 1, 5, -3};    
    cout << maximumSubarraySum(array) << endl;
    return 0;
}
