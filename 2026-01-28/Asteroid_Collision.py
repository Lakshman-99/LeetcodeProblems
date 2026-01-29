from typing import List


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        if not asteroids:
            return []

        stack = []
        for asteroid in asteroids:
            while stack and asteroid < 0 < stack[-1]:
                collision = stack[-1] + asteroid
                if collision < 0:
                    stack.pop()
                    continue
                elif collision == 0:
                    stack.pop()
                break
            else:
                stack.append(asteroid)

        return stack


sol = Solution()
print(sol.asteroidCollision([5,10,-5]))