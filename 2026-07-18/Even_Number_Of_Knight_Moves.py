class Solution:
    def canReach(self, start: list[int], target: list[int]) -> bool:
        x1, y1 = start
        x2, y2 = target

        x = abs(x1 - x2) % 2 == 0
        y = abs(y1 - y2) % 2 == 0

        return x == y


sol = Solution()
print(sol.canReach([0,0],[1,0]))