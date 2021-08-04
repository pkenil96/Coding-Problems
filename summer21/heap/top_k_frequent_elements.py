import heapq
import collections

def topKFrequentElements(nums, k):
    if nums is None or k == 0:
        return []

        # the time complexity of min heap based solution is
        # O(nlogk) but in worst case, when k == n, the time
        # complexity will become nlogn. To avoid that, we
        # need to put this check
    if len(nums) == k:
        return nums

    result = []
    num_freq = collections.Counter(nums)
    # {1:3, 2:2, 3:1}

    for key, value in num_freq.items():
        heapq.heappush(result, (value, key))
        if len(result) > k:
            heapq.heappop(result)
            heapq.heapify(result)

    ans = [item[1] for item in result]
    return ans