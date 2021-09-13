import heapq
import collections

class Pair:
    def __init__(self, word, count):
        self.word = word
        self.count = count

    def __lt__(self, other):
        if self.count == other.count:
            return self.word > other.word
        return self.count < other.count

    def __eq__(self, other):
        return self.count == other.count and self.word == other.word

def topKFrequent(words, k):
    if len(words) == 0:
        return []

    hmap = collections.Counter(words)
    topkwords = []
    for word in hmap:
        heapq.heappush(topkwords, (Pair(word, hmap.get(word)), hmap.get(word)))
        if len(topkwords) > k:
            heapq.heappop(topkwords)
            # heapq.heapify(topkwords)

    result = []
    for _ in range(k):
        result.append(heapq.heappop(topkwords)[0].word)

    return result[::-1]