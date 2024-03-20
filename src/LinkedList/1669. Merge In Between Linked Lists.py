# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        tmp = list1
        mark = ListNode
        for i in range(a):
            mark = tmp
            tmp = tmp.next
        for i in range(b - a):
            tmp = tmp.next
        mark.next = list2
        while list2.next is not None:
            list2 = list2.next
        list2.next = tmp.next
        return list1


def main():
    l1 = ListNode(10)
    l1.next = ListNode(1)
    l1.next.next = ListNode(13)
    l1.next.next.next = ListNode(6)
    l1.next.next.next.next = ListNode(9)
    l1.next.next.next.next.next = ListNode(5)

    a = 3
    b = 4

    l2 = ListNode(1000000)
    l2.next = ListNode(1000001)
    l2.next.next = ListNode(1000002)

    solution = Solution()
    merged = solution.mergeInBetween(l1, a, b, l2)

    while merged.next is not None:
        print(merged.val, end="->")
        merged = merged.next
    print(merged.val)


if __name__ == "__main__":
    main()
