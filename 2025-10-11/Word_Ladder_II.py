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

        while q:
            word, seq, order = q.popleft()
            if word == endWord:
                answer.append(order.copy())
                continue

            for i in range(len(word)):
                arr = list(word)

                for j in range(26):
                    arr[i] = chr(ord('a') + j)
                    newWord = "".join(arr)

                    if "".join(newWord) in wordList:
                        order.append(newWord)
                        q.append((newWord, seq+1, order.copy()))
                        order.pop()

        return answer


sol = Solution()

print(sol.findLadders("hit", "cog", ["hot","dot","dog","lot","log","cog"]))