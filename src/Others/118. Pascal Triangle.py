from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 1:
            return [[1]]
        i = 1
        res = [[1]]
        prev = [1, 1]
        while i < numRows:
            tmp = [1]
            j = 1
            while j < i:
                tmp.append(prev[j - 1] + prev[j])
                j += 1
            tmp.append(1)
            prev = tmp
            res.append(prev)
            i += 1
        return res


def main():
    sol = Solution()
    numRows = 5
    print(sol.generate(numRows))


if __name__ == '__main__':
    main()
