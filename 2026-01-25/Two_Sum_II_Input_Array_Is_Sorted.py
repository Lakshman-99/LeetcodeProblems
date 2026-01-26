from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        if not numbers:
            return []

        l, r = 0, len(numbers)-1
        if target < numbers[0] * 2 or target > numbers[r] * 2:
            return []

        while l < r:
            sum = numbers[l] + numbers[r]
            if sum == target:
                return [l+1, r+1]

            if sum > target:
                r -= 1
            else:
                l += 1

        return [1, 1]


sol = Solution()
print(sol.twoSum([2,7,11,15], 9))