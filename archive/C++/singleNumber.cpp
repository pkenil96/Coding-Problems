/*
This problem is part of the Leetcode daily challenge
Given a non-empty array of integers, every element 
appears twice except for one. Find that single one.
Note:

Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/
#include <bits/stdc++.h>
#include <climits>
using namespace std;

int findSingleNumber(vector <int> nums){
	map <int, int> hmap;
	int n = nums.size();
	for(int i=0; i<n; i++){
		if(hmap.find(nums[i]) == hmap.end())
			hmap[nums[i]] = 1;
		else
			hmap[nums[i]]++;
	}

	int ans;
	for(auto i: hmap){
		if(i.second == 1)
			return i.first;
	}
	return INT_MIN;
}

int method2(vector <int> nums){
	int ans = 0;
	for(int i=0; i<nums.size(); i++){
		ans = ans ^ nums[i];
	}
	return ans;
}

int main(){
	vector <int> nums = {4,1,2,1,2}; 
	cout << findSingleNumber(nums) << endl;
	cout << method2(nums) << endl;
	return 0;
}