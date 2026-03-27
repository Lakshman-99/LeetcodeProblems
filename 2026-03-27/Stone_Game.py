from typing import List


class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)

        def dfs(i, j):
            if i > j:
                return 0

            if (i + j) % 2 == 1:
                return max(dfs(i+1, j) + piles[i], dfs(i, j-1) + piles[j])
            else:
                return min(dfs(i+1, j) + piles[i], dfs(i, j-1) + piles[j])

        total = sum(piles)
        ans = dfs(0, n-1)

        return total - ans < ans


sol = Solution()
print(sol.stoneGame([5,3,4,5]))