from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        l, r = 0, len(nums)-1
        while l <= r:
            m = l + (r-l) // 2
            if nums[m] == target:
                return True
            elif nums[l] < nums[m]:
                if target > nums[m] or target < nums[l]:
                    l = m + 1
                else:
                    r = m - 1
            elif nums[l] > nums[m]:
                if target < nums[m] or target > nums[r]:
                    r = m - 1
                else:
                    l = m + 1
            else:
                l += 1

        return False


sol = Solution()
print(sol.search([1,0,1,1,1], 0))
