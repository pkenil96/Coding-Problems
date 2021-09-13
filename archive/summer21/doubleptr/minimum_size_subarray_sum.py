'''
https://leetcode.com/problems/minimum-size-subarray-sum/
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
'''
import math
def minimumSubArrayLen(target, nums):
    i, j, _sum, _min = 0, 0, 0, float('inf')
    while j in range(len(nums)):
        _sum += nums[j]
        while _sum >= target:
            _min = min(_min, j - i + 1)
            _sum -= nums[i]
            i += 1
        j += 1
    return 0 if math.isinf(_min) else _min