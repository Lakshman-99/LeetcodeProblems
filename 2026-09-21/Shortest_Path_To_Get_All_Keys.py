from collections import deque


class Solution:
    def shortestPathAllKeys(self, grid: list[str]) -> int:
        m, n = len(grid), len(grid[0])

        visited = set()
        q = deque([])
        target_mask = 0
        for i in range(m):
            for j in range(n):
                cell = grid[i][j]
                if 'a' <= cell <= 'z':
                    target_mask |= 1 << (ord(cell) - ord('a'))
                elif cell == '@':
                    q.append((i, j, 0, 0))
                    visited.add((i, j, 0))

        DIRS = ((0, 1), (0, -1), (1, 0), (-1, 0))
        while q:
            i, j, dist, key_mask = q.popleft()

            if key_mask == target_mask:
                return dist

            for dr, dc in DIRS:
                r, c = dr + i, dc + j
                if 0 <= r < m and 0 <= c < n and grid[r][c] != "#":
                    cell = grid[r][c]
                    new_mask = key_mask
                    if 'a' <= cell <= 'z':
                        new_mask |= 1 << (ord(cell) - ord('a'))

                    state = (r, c, new_mask)
                    if state in visited:
                        continue

                    if 'A' <= cell <= 'Z' and not (new_mask & (1 << (ord(cell) - ord('A')))):
                        continue

                    visited.add(state)
                    q.append((r, c, dist + 1, new_mask))

        return -1


sol = Solution()
print(sol.shortestPathAllKeys(["@...a",".###A","b.BCc"]))