from collections import defaultdict, deque
from typing import List


class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        adj = [[] for _ in range(numCourses)]
        in_degree = [0] * numCourses
        dependency = [set() for _ in range(numCourses)]

        for pre, req in prerequisites:
            adj[pre].append(req)
            in_degree[req] += 1

        def dfs(c):
            in_degree[c] -= 1
            for nei in adj[c]:
                in_degree[nei] -= 1
                dependency[nei].add(c)
                dependency[nei].update(dependency[c])
                if in_degree[nei] == 0:
                    dfs(nei)

        for i in range(numCourses):
            if in_degree[i] == 0:
                dfs(i)

        return [u in dependency[v] for u, v in queries]


sol = Solution()
print(sol.checkIfPrerequisite(2, [], [[1,0],[0,1]]))
print(sol.checkIfPrerequisite(2, [[1,0]], [[0,1],[1,0]]))