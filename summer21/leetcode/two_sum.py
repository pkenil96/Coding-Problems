def twoSum(nums, target):
    '''
        1) Create a dictionary
        2) Iterate over the nums and check if the compliment of the current num exists in the dictionary or not
            2.1) If it exists, return current index and the found value in the dictionary
            2.2) Else, add the current item as the key and its index as the value in dict
    '''
    hmap = {}
    for index, item in enumerate(nums):
        if target - item in hmap:
            return [hmap[target - item], index]
        else:
            hmap[item] = index