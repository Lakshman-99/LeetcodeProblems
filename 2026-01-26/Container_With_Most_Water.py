from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        if not height:
            return 0

        max_area = 0
        l, r = 0, len(height)-1
        while l < r:
            length = r - l
            breadth = min(height[l], height[r])
            max_area = max(max_area, length * breadth)

            if height[l] < height[r]:
                l += 1
            elif height[l] > height[r]:
                r -= 1
            else:
                l += 1
                r -= 1

        return max_area


sol = Solution()
print(sol.maxArea([8,7,2,1]))