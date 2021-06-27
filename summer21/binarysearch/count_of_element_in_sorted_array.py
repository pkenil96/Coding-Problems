def search_first(nums, target):
	pass
	
def search_last(nums, target):
	pass

def count_elements(nums, target):
	if nums is None or len(nums)==0:
		return -1

	first = search_first(nums, target)
	last = search_last(nums, target)
	return last-first+1
