import heapq


class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        heap = []
        for c, v in [(-a, 'a'), (-b, 'b'), (-c, 'c')]:
            if c:
                heapq.heappush(heap, (c, v))

        res = []
        while heap:
            count, ch = heapq.heappop(heap)
            if len(res) > 1 and res[-1] == res[-2] == ch:
                if not heap:
                    break
                count2, ch2 = heapq.heappop(heap)
                res.append(ch2)
                count2 += 1

                if count2:
                    heapq.heappush(heap, (count2, ch2))

                heapq.heappush(heap, (count, ch))
            else:
                res.append(ch)
                count += 1
                if count:
                    heapq.heappush(heap, (count, ch))

        return "".join(res)


sol = Solution()
print(sol.longestDiverseString(7,1,0))