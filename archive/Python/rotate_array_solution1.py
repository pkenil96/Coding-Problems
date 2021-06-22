'''This approach fails to satisfy the test case
that the main function tests here.
'''
def rotate_left(nums, n):
    n1 = n
    while n > 0:
        #rotating the array to left by one position
        array_len = len(nums)
        last_index = array_len - 1
        temp = nums[0]
        for i in range(0, last_index): 
            nums[i] = nums[i+1]
        nums[array_len-1] = temp
        n-=1
    print('Rotated the array to left {} times'.format(n1))
    return nums

def rotate_right(nums, n):
    n1 = n
    while n > 0:
        #rotating the array to right by one position
        array_len = len(nums)
        last_index = array_len - 1
        temp = nums[last_index]
        for i in range(last_index, 0, -1):
            nums[i] = nums[i-1]
        nums[0] = temp
        n-=1
    print('Rotated the array to right {} times'.format(n1))
    return nums

if __name__ == '__main__':
    import csv
    with open('rotate_array_testcase.csv') as f:
        reader = csv.reader(f)
        data = list(reader)
        n = data[0].pop()
        arr = data[0]
        new_array = rotate_right(arr, int(n))
        print(new_array)
