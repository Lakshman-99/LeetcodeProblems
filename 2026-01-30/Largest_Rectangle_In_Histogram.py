from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        maxArea = 0

        for idx, height in enumerate(heights):
            while stack and (idx == len(heights)-1 or heights[stack[-1]] >= height):
                start = stack.pop()
                maxArea = max(maxArea, height * (idx - start))

            stack.append(idx)

        return maxArea


sol = Solution()
print(sol.largestRectangleArea([2,1,5,6,2,3]))
