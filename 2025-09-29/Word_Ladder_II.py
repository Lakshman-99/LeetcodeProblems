from collections import deque
from typing import List


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordList = set(wordList)

        if endWord not in wordList:
            return []

        q = deque()
        q.append((beginWord, 1))

        answer = []
        def dfs(word, l):
            if word == endWord:
                answer.append(l)
                return

            for i in range(len(word)):
                for j in range(26):
                    newWord = word[:i] + chr(ord('a') + j) + word[i+1:]

                    if newWord in wordList:
                        l.append(newWord)
                        wordList.remove(newWord)
                        dfs(newWord, l)
                        l.remove(newWord)

            return

        dfs(beginWord, [beginWord])

        while q:
            word, seq = q.popleft()
            if word == endWord:
                return seq

            for i in range(len(word)):
                for j in range(26):
                    newWord = word[:i] + chr(ord('a') + j) + word[i+1:]

                    if newWord in wordList:
                        q.append((newWord, seq+1))
                        wordList.remove(newWord)

        return answer



sol = Solution()

print(sol.findLadders("hit", "cog", ["hot","dot","dog","lot","log","cog"]))