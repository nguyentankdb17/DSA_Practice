class Solution:
    def mostPopularCreator(self, creators: list[str], ids: list[str], views: list[int]) -> list[list[str]]:
        res = [[]]
        n = len(creators)
        mymax = -1
        mydict = {}
        for i in range(n):
            if creators[i] in mydict:
                mydict[creators[i]][1] += views[i]
                mymax = max(mymax, mydict[creators[i]][1])
            else:
                mydict[creators[i]] = [ids[i], views[i]]

        res = []
        for i in mydict:
            if res[i][1] == mymax:
                res.append([i, mydict[i][0]])
        return res


def main():
    sol = Solution()
    creators = ["alice", "bob", "alice", "chris"]
    ids = ["one", "two", "three", "four"]
    views = [5, 10, 5, 4]
    print(sol.mostPopularCreator(creators, ids, views))


if __name__ == "__main__":
    main()
