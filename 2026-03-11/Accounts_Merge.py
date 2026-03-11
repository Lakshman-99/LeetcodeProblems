from typing import List

class DSU:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [1] * n

    def get_parent(self, node):
        cur = node
        while cur != self.parent[cur]:
            self.parent[cur] = self.parent[self.parent[cur]]
            cur = self.parent[cur]
        return cur

    def union(self, u, v):
        pu, pv = self.get_parent(u), self.get_parent(v)
        if pu == pv: return False
        if self.rank(pv) > self.rank(pu):
             pu, pv = pv, pu

        self.parent[pv] = pu
        self.rank[pu] += self.rank[pv]
        return True

class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        email_map = {}
        for i, account in enumerate(accounts):
            user_name = account[0]
            for acc in account[1:]:
                email_map[account[i]] = user_name



sol = Solution()
print(sol.accountsMerge([["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]))