from collections import deque
from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord == endWord:
            return 1

        wordList = set(wordList)
        q = deque([(beginWord, 1)])

        while q:
            word, seq = q.popleft()
            if word == endWord:
                return seq

            for i in range(len(word)):
                wordArr = list(word)

                for j in range(26):
                    wordArr[i] = chr(j + ord('a'))
                    newWord = "".join(wordArr)

                    if newWord in wordList:
                        q.append((newWord, seq + 1))
                        wordList.remove(newWord)

        return 0


sol = Solution()
print(sol.ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))