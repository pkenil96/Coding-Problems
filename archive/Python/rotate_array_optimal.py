'''Algorithm:
1) Reverse the entire array
2) Reverse the first n items in the array
3) Reverse the last n-k items in the array
'''

def rotate_right(nums, n):
    nums.reverse()
    first_n = nums[0:n]
    first_n.reverse()
    last_n_k = nums[n:len(nums)]
    last_n_k.reverse()
    nums = first_n + last_n_k
    print(nums)    


if __name__ == '__main__':
    arr = [1,2,3,4,5,6,7]
    print(arr)
    rotate_right(arr, 3)
    print(arr)
