from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0

        n = len(nums)
        count = 0
        # brute force
        # for i in range(n):
        #     cur_sum = 0
        #     for j in range(i, n):
        #         cur_sum += nums[j]
        #
        #         if cur_sum == k:
        #             count += 1

        # optimized
        prefix = {0: 1}
        cur_sum = 0
        for num in nums:
            cur_sum += num

            if cur_sum - k in prefix:
                count += prefix[cur_sum - k]

            prefix[cur_sum] = 1 + prefix.get(cur_sum, 0)

        return count


sol = Solution()
print(sol.subarraySum([-1,-1,1], 0))
