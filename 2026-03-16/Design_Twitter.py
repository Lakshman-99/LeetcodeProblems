import heapq
from collections import defaultdict
from typing import List


class Twitter:

    def __init__(self):
        self.network = defaultdict(set)
        self.posts = defaultdict(list)
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.posts[userId].append((self.time, tweetId))
        self.time += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        res = []
        heap = []
        followers = [userId] + list(self.network[userId])

        for followee in followers:
            if followee in self.posts:
                index = len(self.posts[followee]) - 1
                timeStamp, tweetId = self.posts[followee][index]
                heapq.heappush(heap, (-timeStamp, tweetId, followee, index - 1))

        while heap and len(res) < 10:
            timeStamp, tweetId, followee, index = heapq.heappop(heap)
            res.append(tweetId)

            if index >= 0:
                timeStamp, tweetId = self.posts[followee][index]
                heapq.heappush(heap, (-timeStamp, tweetId, followee, index - 1))

        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        self.network[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.network[followerId].discard(followeeId)


operations = ["Twitter","postTweet","postTweet","getNewsFeed"]
values = [[],[1,5],[1,3],[1]]

obj = None
results = []

for op, val in zip(operations, values):
    if op == "Twitter":
        obj = Twitter()
        results.append(None)

    elif op == "postTweet":
        obj.postTweet(val[0], val[1])
        results.append(None)

    elif op == "getNewsFeed":
        res = obj.getNewsFeed(val[0])
        results.append(res)

    elif op == "follow":
        obj.follow(val[0], val[1])
        results.append(None)

    elif op == "unfollow":
        obj.unfollow(val[0], val[1])
        results.append(None)

print(results)