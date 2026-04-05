from collections import defaultdict
from typing import List


class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adj = defaultdict(list)
        for src, dest in sorted(tickets, reverse=True):
            adj[src].append(dest)

        res = []
        def dfs(node):
            while adj[node]:
                dfs(adj[node].pop())
            res.append(node)

        dfs("JFK")
        return res[::-1]

    def findItinerary2(self, tickets: List[List[str]]) -> List[str]:
        tickets.sort()
        adj = {src: [] for src, _ in tickets}

        for src, dest in tickets:
            adj[src].append(dest)

        res = ["JFK"]

        def dfs(node):
            if len(res) == len(tickets) + 1:
                return True
            if node not in adj:
                return False

            temp = list(adj[node])
            for i, nei in enumerate(temp):
                adj[node].pop(i)
                res.append(nei)
                if dfs(nei):
                    return True

                adj[node].insert(i, nei)
                res.pop()

            return False

        dfs('JFK')
        return res


sol = Solution()
print(sol.findItinerary([["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]))