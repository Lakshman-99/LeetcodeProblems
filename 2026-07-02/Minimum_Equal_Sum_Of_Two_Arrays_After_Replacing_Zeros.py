from typing import List


class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        s1 = s2 = c1 = c2 = 0
        for num in nums1:
            s1 += num
            c1 += num == 0

        for num in nums2:
            s2 += num
            c2 += num == 0

        if (c1 == 0 and c2 == 0) or (c1 == 0 and s1 - s2 < c2) or (c2 == 0 and s2 - s1 < c1):
            return -1

        return max(s1+c1, s2+c2)


sol = Solution()
print(sol.minSum([20,0,18,11,0,0,0,0,0,0,17,28,0,11,10,0,0,15,29], [16,9,25,16,1,9,20,28,8,0,1,0,1,27]))
