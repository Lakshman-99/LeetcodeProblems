import heapq
from collections import defaultdict, deque
from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj = defaultdict(list)
        for frm, dest, cost in flights:
            adj[frm].append((dest, cost))

        prices = [float('inf')] * n
        prices[src] = 0

        q = deque([(0, 0, src)])
        while q:
            price, stops, city = q.popleft()
            if stops > k:
                continue

            for nei, nei_cost in adj[city]:
                new_price = price + nei_cost
                if new_price < prices[nei]:
                    prices[nei] = new_price
                    q.append((new_price, stops+1, nei))

        return prices[dst] if prices[dst] != float('inf') else -1

    def findCheapestPrice2(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj = defaultdict(list)
        for frm, dest, cost in flights:
            adj[frm].append((dest, cost))

        min_stops = [float('inf')] * n
        min_heap = [(0, 0, src)]

        while min_heap:
            price, stops, city = heapq.heappop(min_heap)
            if city == dst:
                return price

            if stops > k or stops >= min_stops[city]:
                continue

            min_stops[city] = stops
            for nei, nei_cost in adj[city]:
                heapq.heappush(min_heap, (price + nei_cost, stops+1, nei))

        return -1


sol = Solution()
print(sol.findCheapestPrice(4, [[0,1,1],[0,2,5],[1,2,1],[2,3,1]], 0, 3, 1))