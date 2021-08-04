import heapq
import collections

k = 4
words = ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]
freq = collections.Counter(words)

class Item:
    def __init__(self, key, val):
        self.key = key
        self.val = val

    def __lt__(self, other):
        if self.val == other.val:
            return self.key > other.key
        return self.val > other.val

    def __eq__(self, other):
        return self.val == other.val and self.key == other.key

def topKFrequent(words, k):
    freq_map = collections.Counter(words)
    topkwords = []
    for key, value in freq_map.items():
        heapq.heappush(topkwords, Item(key, value))
        if len(topkwords) > k:
            heapq.heappop(topkwords)

    result = []
    for _ in range(k):
        result.append(heapq.heappop(topkwords).word)
    return result[::-1]