from collections import defaultdict, deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dependency = {i: [] for i in range(numCourses)}

        for a, b in prerequisites:
            dependency[a].append(b)

        cache = set()
        def dfs(course, visited):
            if course in cache: return True
            if course in visited: return False

            visited.add(course)
            for dep in dependency[course]:
                if not dfs(dep, visited):
                    return False

                cache.add(dep)

            return True

        for i in range(numCourses):
            if not dfs(i, set()):
                return False

            cache.add(i)

        return True


sol = Solution()
print(sol.canFinish(3, [[0,1],[0,2],[1,2]]))