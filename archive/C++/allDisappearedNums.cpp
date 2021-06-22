#include <bits/stdc++.h>
using namespace std;

typedef vector<int> VI;

void missingIntegers(VI nums){
	VI ans;
	unordered_set <int> mySet(nums.begin(), nums.end());
	for(const int i : mySet)
		cout << i << endl;
}

int main(){
	VI nums = {4,3,2,7,8,2,3,1};
	missingIntegers(nums);
	return 0;
}