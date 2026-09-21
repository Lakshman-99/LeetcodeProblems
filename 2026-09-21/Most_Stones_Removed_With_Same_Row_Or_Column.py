class DSU:
    def __init__(self, n):
        self.components = 0
        self.parent = list(range(n))
        self.size = [1] * n
        self.unique_nodes = set()

    def get_components(self):
        return self.components

    def _find(self, node):
        if node not in self.unique_nodes:
            self.components += 1
            self.unique_nodes.add(node)

        if self.parent[node] == node:
            return node
        self.parent[node] = self._find(self.parent[node])
        return self.parent[node]

    def union(self, a, b):
        pa = self._find(a)
        pb = self._find(b)
        if pa == pb:
            return

        if self.size[pb] > self.size[pa]:
            pa, pb = pb, pa

        self.parent[pb] = pa
        self.size[pa] += self.size[pb]
        self.components -= 1
        return

class Solution:
    def removeStones(self, stones: list[list[int]]) -> int:
        n = len(stones)
        dsu = DSU(20001)

        for a, b in stones:
            dsu.union(a, b + 10001)

        return n - dsu.get_components()


sol = Solution()
print(sol.removeStones([[3,3],[4,4],[1,4],[1,5],[2,3],[4,3],[2,4]]))