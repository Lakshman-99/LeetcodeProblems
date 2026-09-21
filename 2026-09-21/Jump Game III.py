from collections import deque


class Solution:
    def canReach(self, arr: list[int], start: int) -> bool:
        if 0 not in arr:
            return False

        n = len(arr)
        q = deque([start])
        seen = set()
        while q:
            idx = q.popleft()
            val = arr[idx]
            if val == 0:
                return True

            seen.add(idx)
            if 0 <= idx - val and idx - val not in seen:
                q.append(idx - val)

            if idx + val < n and idx + val not in seen:
                q.append(idx + val)

        return False




sol = Solution()
print(sol.canReach([4,2,3,0,3,1,2], 5))