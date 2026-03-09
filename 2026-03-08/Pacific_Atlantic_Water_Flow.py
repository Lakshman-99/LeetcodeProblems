from typing import List


class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        DIRS = [(0,1),(1,0),(0,-1),(-1,0)]
        m, n = len(heights), len(heights[0])
        atlantic, pacific = set(), set()

        def dfs(r, c, store):
            if (r, c) in store:
                return

            store.add((r, c))
            for x, y in DIRS:
                R, C = r+x, c+y
                if 0 <= R < m and 0 <= C < n and heights[r][c] <= heights[R][C]:
                    dfs(R, C, store)

        for i in range(n):
            dfs(0, i, pacific)
            dfs(m-1, i, atlantic)

        for i in range(m):
            dfs(i, 0, pacific)
            dfs(i, n-1, atlantic)

        res = []
        for r in range(m):
            for c in range(n):
                if (r, c) in atlantic and (r, c) in pacific:
                    res.append([r, c])

        return res


sol = Solution()
print(sol.pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))