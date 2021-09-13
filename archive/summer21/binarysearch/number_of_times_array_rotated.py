def number_of_rotations(nums):
	'''Returns how many times a sorted array is rotated'''
	if nums is None or len(nums)==0:
		return -1
		
	# for some index i, if arr[i] < arr[i-1] and arr[i] < arr[i+1]
	# let's call it a pivot element(minimum). The index of the pivot element
	# will give us the number of times array was rotated
	low = 0
	n = len(nums)
	high = n - 1
	
	while low<=high:
		mid = low + (high-low)//2
		prev_mid = (mid - 1 + n)%n
		next_mid = (mid + 1)%n
		
		if nums[mid] < nums[prev_mid] and nums[mid] <= nums[next_mid]:
			return mid
		
		if nums[mid] < nums[low]:
			high = mid - 1
		elif nums[mid] > nums[high]:
			low = mid + 1
		else:
			return 0
	
	
