from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix)-1, len(matrix[0])-1
        l, r = 0, m
        while l <= r:
            mid = l + (r-l) // 2
            if matrix[mid][n] == target:
                return True
            elif target > matrix[mid][n]:
                l = mid + 1
            else:
                r = mid - 1

        if l > m:
            return False

        row = l
        l, r = 0, n
        while l <= r:
            mid = l + (r - l) // 2
            if matrix[row][mid] == target:
                return True
            elif target > matrix[row][mid]:
                l = mid + 1
            else:
                r = mid - 1

        return False


sol = Solution()
print(sol.searchMatrix([[1]], 2))
