from collections import defaultdict, deque
from typing import List


class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        safe = set()
        unsafe = set()
        pathVisited = set()
        def dfs(node):
            if node in pathVisited:
                 return False

            pathVisited.add(node)
            count = 0
            for i in graph[node]:
                if i in unsafe:
                    return False

                if i in safe or dfs(i):
                    count += 1

            pathVisited.remove(node)
            if count == len(graph[node]):
                safe.add(node)
                return True

            unsafe.add(node)
            return False

        for i in range(len(graph)):
            if i not in unsafe:
                dfs(i)

        return sorted(safe)

sol = Solution()

print(sol.eventualSafeNodes([[1,2],[2,3],[5],[0],[5],[],[]]))
print(sol.eventualSafeNodes([[1,2,3,4],[1,2],[3,4],[0,4],[]]))
print(sol.eventualSafeNodes([[],[0,2,3,4],[3],[4],[]]))