from typing import List


class Solution:
    def merge(self, left, right) -> List[int]:
        n, m = len(left), len(right)
        i = j = 0

        sorted_arr = []
        while i < n and j < m:
            if left[i] < right[j]:
                sorted_arr.append(left[i])
                i += 1
            else:
                sorted_arr.append(right[j])
                j += 1

        sorted_arr.extend(left[i:])
        sorted_arr.extend(right[j:])

        return sorted_arr

    def mergeSort(self, nums, start, end) -> List[int]:
        if start == end:
            return [nums[end]]

        mid = end + (start - end) // 2
        left = self.mergeSort(nums, start, mid)
        right = self.mergeSort(nums, mid + 1, end)

        return self.merge(left, right)

    def partition(self, nums, low, high):
        mid = low + (high - low) // 2

        if nums[low] > nums[mid]:
            nums[low], nums[mid] = nums[mid], nums[low]
        if nums[low] > nums[high]:
            nums[low], nums[high] = nums[high], nums[low]
        if nums[mid] > nums[high]:
            nums[mid], nums[high] = nums[high], nums[mid]

        nums[mid], nums[high] = nums[high], nums[mid]
        pivot = nums[high]

        i = low
        for j in range(low, high):
            if nums[j] < pivot:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1

        nums[i], nums[high] = nums[high], nums[i]
        return i

    def quickSort(self, nums, low, high):
        if low >= high:
            return

        pivot = self.partition(nums, low, high)
        self.quickSort(nums, low, pivot-1)
        self.quickSort(nums, pivot+1, high)

    def sortArray(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        # return self.mergeSort(nums, 0, len(nums) - 1)
        self.quickSort(nums, 0, len(nums) - 1)
        return nums


sol = Solution()
print(sol.sortArray([2, 10, 7, 9, 3, 11, 15, 1]))