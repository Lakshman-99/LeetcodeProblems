from collections import deque
from typing import List


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if beginWord == endWord:
            return []

        wordList = set(wordList)

        q = deque()
        q.append((beginWord, 1, [beginWord]))

        answer = []
        MAX_VALUE = 2 ** 31 - 1
        minLen = MAX_VALUE

        while q:
            qLen = len(q)
            discard = []

            for l in range(qLen):
                word, seq, order = q.popleft()
                discard.append(word)

                if minLen != MAX_VALUE and len(order) != minLen:
                    continue

                if word == endWord and len(order) <= minLen:
                    minLen = len(order)
                    answer.append(order.copy())
                    continue

                unique = set(order)
                for i in range(len(word)):
                    for j in range(26):
                        newWord = word[:i] + chr(ord('a') + j) + word[i+1:]

                        if newWord in wordList and newWord not in unique:
                            newOrder = order.copy()
                            newOrder.append(newWord)
                            q.append((newWord, seq+1, newOrder))

            wordList.difference_update(discard)

        return answer


sol = Solution()

print(sol.findLadders("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
print(sol.findLadders("hit", "cog", ["hot","dot","dog","lot","log"]))