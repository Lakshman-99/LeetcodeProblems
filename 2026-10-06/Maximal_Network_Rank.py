from collections import defaultdict


class Solution:
    def maximalNetworkRank(self, n: int, roads: list[list[int]]) -> int:
        if not n or not roads:
            return 0

        degree = defaultdict(set)
        for a, b in roads:
            degree[a].add(b)
            degree[b].add(a)

        max_rank = 0
        for i in range(n):
            for j in range(i+1, n):
                cur = len(degree[i]) + len(degree[j])
                if j in degree[i]:
                    cur -= 1
                max_rank = max(max_rank, cur)

        return max_rank


sol = Solution()
print(sol.maximalNetworkRank(2, [[1,0]]))