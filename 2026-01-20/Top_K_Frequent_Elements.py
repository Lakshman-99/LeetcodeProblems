import heapq
from collections import Counter
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums or k <= 0:
            return []

        if len(nums) == k:
            return list(set(nums))

        # brute force - o(nlogn)
        # sort = sorted(Counter(nums).items(), key=lambda x : x[1], reverse=True)
        # [sort[i][0] for i in range(k)]

        # using min-heap(Python default - Min at top)
        # counter = Counter(nums)
        # res = []
        # for key, v in counter.items():
        #     heapq.heappush(res, (v, key))
        #     if len(res) > k:
        #         heapq.heappop(res)

        # [key for _, key in res]

        # Optimized bucket sort - Max freq can atmost be len of arr - o(n)
        counter = Counter(nums)
        buckets = [[] for _ in range(len(nums) + 1)]

        for key, val in counter.items():
            buckets[val].append(key)

        res = []
        for i in range(len(buckets) - 1, 0, -1):
            for num in buckets[i]:
                res.append(num)
                if len(res) == k:
                    return res

        return res


sol = Solution()
print(sol.topKFrequent([0,2,0,2,1,1,0], 2))