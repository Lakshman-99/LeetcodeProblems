from collections import deque


class Solution:
    def racecar(self, target: int) -> int:
        q = deque([(0, 1, 0)])
        while q:
            pos, speed, step = q.popleft()
            if pos == target:
                return step

            np, ns = pos + speed, speed * 2
            q.append((np, ns, step + 1))

            if (np > target and speed > 0) or (np < target and speed < 0):
                rs = -1 if speed > 0 else 1
                q.append((pos, rs, step + 1))

        return -1

    def racecar2(self, target: int) -> int:
        q = deque([(0, 1, 0)])
        seen ={(0, 1)}
        while q:
            pos, speed, step = q.popleft()
            if pos == target:
                return step

            np, ns = pos + speed, speed * 2
            if (np, ns) not in seen and 0 < np < 2 * target:
                seen.add((np, ns))
                q.append((np, ns, step + 1))

            rs = -1 if speed >= 0 else 1
            if (pos, rs) not in seen:
                seen.add((pos, rs))
                q.append((pos, rs, step + 1))

        return -1


sol = Solution()
print(sol.racecar(12))