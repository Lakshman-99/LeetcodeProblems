from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n, jump = len(nums), 0

        for i in range(n):
            if jump < i:
                break
            jump = max(jump, i + nums[i])

        return jump >= n - 1


sol = Solution()
print(sol.canJump([0]))