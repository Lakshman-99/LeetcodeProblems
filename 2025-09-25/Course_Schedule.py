from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dict = {}

        for a, b in prerequisites:
            if a in dict.keys():
                dict[a].append(b)
            else:
                dict[a] = [b]

            if b not in dict.keys():
                dict[b] = []

        print(dict)
        def dfs(key, visited):
            if visited[key] == 1:
                return False

            if visited[key] == 2:
                return True

            visited[key] = 1
            for prerequisite in dict[key]:
                if not dfs(prerequisite, visited):
                    return False

            visited[key] = 2
            return True


        visited = [0] * numCourses
        for key in dict.keys():
            if not dfs(key, visited):
                return False

        print(True)
        return True

sol = Solution()

sol.canFinish(2, [[1,0]])
sol.canFinish(2, [[1,0],[0,1]])
sol.canFinish(5, [[1,4],[2,4],[3,1],[3,2]])