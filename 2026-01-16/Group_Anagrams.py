from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if not strs:
            return []

        anagram_map = defaultdict(list)

        # brute force - o(n * m * logm)
        # for str in strs:
        #     sorted_str = "".join(sorted(str))
        #     anagram_map[sorted_str] .append(str)

        # optimized(26 chars) - o(n * m)
        # for str in strs:
        #     freq = [0] * 26
        #     for c in str:
        #         freq[ord(c) - ord('a')] += 1
        #
        #     anagram_map[tuple(freq)].append(str)

        # Optimal(all chars with unicode) - o(n * (m + ulogu))
        for str in strs:
            freq = defaultdict(int)
            for c in str:
                freq[c] += 1

            key = tuple(sorted(freq.items()))
            anagram_map[key].append(str)

        return list(anagram_map.values())


sol = Solution()
print(sol.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))