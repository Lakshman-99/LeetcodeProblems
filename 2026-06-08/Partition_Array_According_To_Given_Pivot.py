from typing import List


class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        less = []
        great = []
        p_count = 0

        for num in nums:
            if num < pivot:
                less.append(num)
            elif num > pivot:
                great.append(num)
            else:
                p_count += 1

        return less + [pivot] * p_count + great


sol = Solution()
print(sol.pivotArray([-3,4,3,2], 2))