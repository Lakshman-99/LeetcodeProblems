from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []

        n = len(nums)-1
        nums.sort()
        res = []
        for i, num in enumerate(nums):
            if num > 0:
                break

            if i > 0 and num == nums[i - 1]:
                continue

            l, r = i+1, n
            while l < r:
                sum = nums[i] + nums[l] + nums[r]

                if sum == 0:
                    res.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1

                    while l < r and nums[l] == nums[l-1]:
                        l += 1
                elif sum < 0:
                    l += 1
                else:
                    r -= 1

        return res


sol = Solution()
print(sol.threeSum([-1,0,1,2,-1,-4]))