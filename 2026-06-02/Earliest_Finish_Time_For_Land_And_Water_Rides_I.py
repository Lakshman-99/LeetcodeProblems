from typing import List


class Solution:
    def earliestFinishTime(self, a: List[int], b: List[int], c: List[int], d: List[int]) -> int:
        land_rides = [a[i] + b[i] for i in range(len(a))]
        water_rides = [c[i] + d[i] for i in range(len(c))]

        min_land = min(land_rides)
        min_water = min(water_rides)

        land = [max(min_water, a[i]) + b[i] for i in range(len(a))]
        water = [max(min_land, c[i]) + d[i] for i in range(len(c))]

        return min(min(land), min(water))


sol = Solution()
print(sol.earliestFinishTime([99], [59], [99,54], [85,20]))