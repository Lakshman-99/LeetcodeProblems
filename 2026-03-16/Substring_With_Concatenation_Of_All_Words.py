from collections import defaultdict
from typing import List


class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        word_freq = defaultdict(int)
        win_len = 0
        word_len = len(words[0])
        for word in words:
            word_freq[word] += 1
            win_len += len(word)

        res = []
        for i in range(len(s)-win_len+1):
            if s[i:i + word_len] not in word_freq:
                continue

            cur_freq = dict(word_freq)
            for j in range(i, i+win_len, word_len):
                word = s[j:j + word_len]
                if word not in cur_freq:
                    break

                cur_freq[word] -= 1
                if cur_freq[word] == 0:
                    cur_freq.pop(word)

            if not cur_freq:
                res.append(i)

        return res


sol = Solution()
print(sol.findSubstring("wordgoodgoodgoodbestword", ["word","good","best","good"]))