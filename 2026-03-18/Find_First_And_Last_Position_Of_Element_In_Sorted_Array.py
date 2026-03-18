from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def bin_search(left_bound=False):
            l, r = 0, len(nums) - 1

            while l < r:
                m = (l + r) // 2

                if left_bound:
                    if target <= nums[m]:
                        r = m - 1
                    else:
                        l = m + 1
                else:
                    if target < nums[m]:
                        r = m - 1
                    else:
                        l = m + 1

            return -1 if nums[l] != target else l

        return [bin_search(True), bin_search()]


sol = Solution()
print(sol.searchRange([5,7,7,8,8,10], 8))