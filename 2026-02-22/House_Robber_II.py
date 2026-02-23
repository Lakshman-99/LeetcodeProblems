from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        def get_max_loot(houses):
            rob1 = 0
            rob2 = 0

            for house in houses:
                temp = max(house + rob1, rob2)
                rob1 = rob2
                rob2 = temp

            return rob2

        return max(nums[0], get_max_loot(nums[1:]), get_max_loot(nums[:-1]))


sol = Solution()
print(sol.rob([2,3,2]))