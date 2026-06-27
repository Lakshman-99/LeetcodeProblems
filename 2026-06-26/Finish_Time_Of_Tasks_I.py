from typing import List


class Solution:
    def finishTime(self, n: int, edges: List[List[int]], baseTime: List[int]) -> int:
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)

        def dfs(node):
            if not adj[node]:
                return baseTime[node]

            ans = [dfs(ch) for ch in adj[node]]
            early, latest = min(ans), max(ans)
            ownDur = latest - early + baseTime[node]

            return latest + ownDur

        return dfs(0)


sol = Solution()
print(sol.finishTime(3, [[0,1],[1,2]], [9,5,3]))