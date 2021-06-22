'''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
'''

def longest_common_prefix(strs):
	prefix = ""
	if strs is None or len(strs) == 0:
		return prefix
	prefix = min(strs, key=len)
	for string in strs:
		while string.find(prefix) != 0:
			prefix = prefix[0:len(prefix)-1]
	return prefix

if __name__ == '__main__':
	strs = ["apple", "ape", "appu", "psara", "appealing"]
	print(longest_common_prefix(strs))
