from typing import List
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord == endWord:
            return 1

        queue = deque()
        queue.append([beginWord, 1])
        wordList = set(wordList)

        while queue:
            word, seq = queue.popleft()
            if word == endWord:
                return seq

            for i in range(len(word)):
                wordArr = list(word)

                for j in range(26):
                    wordArr[i] = chr(j + ord('a'))

                    newWord = "".join(wordArr)

                    if newWord in wordList:
                        queue.append([newWord, seq+1])
                        wordList.remove(newWord)

        return 0

sol = Solution()

print(sol.ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))