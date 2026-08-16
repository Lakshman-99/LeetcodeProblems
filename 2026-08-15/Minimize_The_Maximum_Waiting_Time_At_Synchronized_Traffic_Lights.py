class Solution:
    def minPenalty(self, period: int, lights: list[int], arrivalTime: list[int]) -> int:
        ml = max(lights)
        penalty = 0

        for time in arrivalTime:
            r = time % period
            if r >= ml:
                penalty = max(penalty, period - r)

        return penalty

sol = Solution()
print(sol.minPenalty(8, [2,3], [2,5,8,11]))