class Solution:
    def criticalConnections(self, n: int, connections: list[list[int]]) -> list[list[int]]:
        adj = [[] for _ in range(n)]
        for a, b in connections:
            adj[a].append(b)
            adj[b].append(a)

        seen = [False] * n
        depth = [0] * n
        valid = []
        st = []

        def dfs(node, parent):
            seen[node] = True
            for nei in adj[node]:
                if nei == parent:
                    continue

                if not seen[nei]:
                    depth[nei] = depth[node] + 1
                    st.append((node, nei))
                    dfs(nei, node)
                elif depth[nei] < depth[node]:
                    while st and depth[st[-1][1]] > depth[nei]:
                        st.pop()

            if st and st[-1][1] == node:
                valid.append(st.pop())
            return

        for i in range(n):
            if not seen[i]:
                dfs(i, -1)

        return valid


sol = Solution()
print(sol.criticalConnections(6, [[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]))