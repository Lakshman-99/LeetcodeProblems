from typing import List


class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if sum(matchsticks) % 4 != 0:
            return False

        matchsticks.sort(reverse=True)
        length = sum(matchsticks) // 4
        sides = [0] * 4

        def dfs(i):
            if i == len(matchsticks):
                return True

            for j in range(4):
                if sides[j] + matchsticks[i] <= length:
                    sides[j] += matchsticks[i]
                    if dfs(i+1):
                        return True
                    sides[j] -= matchsticks[i]

                if sides[j] == 0:
                    return False

            return False

        return dfs(0)


sol = Solution()
print(sol.makesquare([1,1,2,2,2]))