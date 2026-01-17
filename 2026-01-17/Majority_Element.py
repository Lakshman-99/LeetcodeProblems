from collections import defaultdict
from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        if not nums:
            return 0

        # brute force o(nlogn)
        # count = defaultdict(int)
        # for num in nums:
        #     count[num] = count[num] + 1
        #
        # answer = sorted(count.items(), key=lambda x: x[1], reverse=True)[0][0]

        # optimized - o(n)
        candidate = None
        count = 0
        for num in nums:
            if count == 0:
                candidate = num

            if num == candidate:
                count += 1
            else:
                count -= 1

        return candidate



sol = Solution()
print(sol.majorityElement([2,2,1,1,1,1,1,1,2,2]))