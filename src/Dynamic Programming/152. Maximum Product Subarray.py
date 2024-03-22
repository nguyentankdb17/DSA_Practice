class Solution:
    def maxProduct(self, nums: list[int]) -> int:
        res = max(nums)
        currMin, currMax = 1, 1

        for n in nums:
            if n == 0:
                currMax, currMin = 1, 1
                continue
            tmp = currMax * n
            currMax = max(currMax * n, currMin * n, n)
            currMin = min(tmp, currMin * n, n)
            res = max(res, currMax)
        return res


def main():
    sol = Solution()
    nums = [1, 2, 3, -3, 3]
    print(sol.maxProduct(nums))


if __name__ == "__main__":
    main()
