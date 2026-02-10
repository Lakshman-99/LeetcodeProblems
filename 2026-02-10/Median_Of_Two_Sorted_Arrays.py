from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1, n2 = len(nums1), len(nums2)
        h = (n1 + n2) // 2
        if n1 > n2:
            nums1, nums2 = nums2, nums1
            n1, n2 = n2, n1

        l, r = 0, n1-1
        while l <= r:
            i = l + (r - l) // 2
            j = h - i - 2

            l1 = nums1[i] if i >= 0 else float('-inf')
            r1 = nums1[i+1] if i+1 < n1 else float('inf')
            l2 = nums2[j] if j >= 0 else float('-inf')
            r2 = nums2[j+1] if j + 1 < n2 else float('inf')

            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) & 1:
                    return min(r1,r2)
                else:
                    return (max(l1, l2) + min(r1,r2)) / 2.0
            elif l1 > r2:
                r = i - 1
            else:
                l = i + 1

        return nums1[l]





sol = Solution()
print(sol.findMedianSortedArrays([1,3,4,10], [6,7,12,14,18,20,21]))
