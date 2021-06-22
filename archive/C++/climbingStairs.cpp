#include <bits/stdc++.h>
using namespace std;

int waysToClimbStairs(int n){
	if(n==0) return 1;
	if(n==1) return 1;
	
	int array[n];
	for(int i=0; i<n; i++)
		array[i] = 0;
	
	array[0] = 1;
	array[1] = 1;
	for(int i=2; i<=n; i++)
		array[i] = array[i-1] + array[i-2];
	return array[n];
}

int main(){
	int n = 6;
	cout << waysToClimbStairs(n) << endl;
	return 0;
}