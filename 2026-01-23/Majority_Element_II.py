from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        cand1 = cand2 = None
        c1 = c2 = 0
        for num in nums:
            if num == cand1:
                c1 += 1
            elif num == cand2:
                c2 += 1
            elif c1 == 0:
                cand1, c1 = num, 1
            elif c2 == 0:
                cand2, c2 = num, 1
            else:
                c1, c2 = c1 - 1, c2 - 1

        ans = []
        for c in [cand1, cand2]:
            if c is not None and nums.count(c) > len(nums)/3:
                ans.append(c)

        return ans


sol = Solution()
# print(sol.majorityElement([3,3,3]))
print(sol.majorityElement([1,2,1,2,2,3,3,1]))
print(sol.majorityElement([1,2,3]))