def search_rotated_util(nums, low, high, target):
	mid = (low + high)//2
	if low > high:
		return -1
	if nums[mid]==target:
		return mid
	
	# first half is perfectly sorted and second half is not
	if nums[low] <= nums[mid]:
		# first half is perfectly sorted and target is in sorted half
		if nums[low] <= target and target <= nums[mid]:
			return search_rotated_util(nums, low, mid-1, target)
		# first half is perfectly sorted but target is in unsorted half
		else:
			return search_rotated_util(nums, mid+1, high, target)
	# second half is perfectly sorted and first half is not
	else:
		# second half is perfectly sorted and target is in first half
		if nums[mid] <= target and target <= nums[high]:
			return search_rotated_util(nums, mid+1, high, target)
		# second half is perfectly sorted and target is in second half
		else:
			return search_rotated_util(nums, low, mid-1, target)		


def search_rotated(nums, target):
	'''Returns the index of the target element if 
	present else returns -1'''
	if nums is None or len(nums)==0:
		return -1
	
	return search_rotated_util(nums, 0, len(nums)-1, target)


