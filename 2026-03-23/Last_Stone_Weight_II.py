from typing import List


class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        n = len(stones)
        MAX = (1 << 31) - 1
        dp = [[MAX] * (n+1) for _ in range(n+1)]



    def lastStoneWeightII2(self, stones: List[int]) -> int:
        n = len(stones)
        MAX = (1 << 31) - 1

        def dfs(i, st):
            if i == 0:
                pass

            while st and len(st)


        return dfs(n-1, [])


sol = Solution()
print(sol.lastStoneWeightII([2,7,4,1,8,1]))