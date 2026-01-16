from typing import List


class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        n = len(nums)
        res = [0] * (2 * n)
        for i, num in enumerate(nums):
            res[i] = res[i + n] = num

        return res


sol = Solution()
print(sol.getConcatenation([1,2,1]))