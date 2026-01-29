from typing import List


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        if not asteroids:
            return []

        stack = []
        for asteroid in asteroids:
            skip = False
            while stack and asteroid < 0 < stack[-1]:
                bigAsteroid = stack[-1] + asteroid
                if bigAsteroid <= 0:
                    stack.pop()
                    if asteroid == 0:
                        skip = True
                else:
                    break

            if not skip:
                stack.append(asteroid)

        return stack


sol = Solution()
print(sol.asteroidCollision([5,10,-5]))