from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        maxArea = 0
        n = len(heights)

        for idx in range(n + 1):
            while stack and (idx == n or heights[stack[-1]] >= heights[idx]):
                height = heights[stack.pop()]
                width = idx if not stack else idx - stack[-1] - 1
                maxArea = max(maxArea, height * width)

            stack.append(idx)

        return maxArea


sol = Solution()
print(sol.largestRectangleArea([2,1,5,6,5,3]))
