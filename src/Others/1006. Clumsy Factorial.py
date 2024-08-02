class Solution:
    def clumsy(self, n: int) -> int:
        idx = 0
        res = n
        div  = n % 4
        while n > 0 :
            res *= n - 1
            res = res // (n - 2)
            res += n - 3
            res -= n - 4
            n -= 4
        # for i in range(n-1, 0, -1):
        #     if idx % 4 == 0:
        #         res *= i
        #     elif idx % 4 == 1:
        #         res = res // i
        #     elif idx % 4 == 2:
        #         res = res + i
        #     else:
        #         res -= i
        #     idx += 1
        #     print(res,end=" ")
        return res


def main():
    sol = Solution()
    n = 10
    print(sol.clumsy(n))


if __name__ == '__main__':
    main()
