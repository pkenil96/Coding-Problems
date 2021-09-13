def search_first(nums, target):
	first = -1
	low = 0
	high = len(nums) - 1
	
	while low <= high:
		mid = (low+high)//2
		if target < nums[mid]:
			high = mid - 1
		elif target > nums[mid]:
			low = mid + 1
		else:
			first = mid
			# unlike usual binary search, we continue our search for more
			# occurences of target on left and return the one on the most left
			high = mid - 1
	return first


def search_last(nums, target):
	last = -1
	low = 0
	high = len(nums) - 1
	
	while low <= high:
		mid = (low+high)//2
		if target < nums[mid]:
			high = mid - 1
		elif target > nums[mid]:
			low = mid + 1
		else:
			last = mid
			# unlike usual binary search, we continue our search for more
			# occurences of target on right and return the one on the most right
			low = mid + 1
	return last
	

def search_first_and_last(nums, target):
	'''Returns the first and last occurence of
	target in sorted array if present else -1,-1'''
	if nums is None or len(nums)==0:
		return [-1, -1]
	
	first = search_first(nums, target)
	second = search_second(nums, target)
	return [first, second]
