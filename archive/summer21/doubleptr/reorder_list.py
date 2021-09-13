class ListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def getMiddleNode(head):
    prev, slow, fast = None, head, head
    while fast and fast.next:
        prev = slow
        slow = slow.next
        fast = fast.next.next
    return prev, slow

def reverse(head):
    prev = None
    current = head
    while (current is not None):
        next = current.next
        current.next = prev
        prev = current
        current = next
    return prev


def reorder(l1, l2):
    l3 = ListNode(-999)
    res = l3
    odd = True
    while l1 and l2:
        if odd:
            odd = False
            l3.next = l1
            l1 = l1.next
        else:
            odd = True
            l3.next = l2
            l2 = l2.next
        l3 = l3.next

    while l1:
        l3.next = l1
        l1 = l1.next
        l3 = l3.next

    while l2:
        l3.next = l2
        l2 = l2.next
        l3 = l3.next

    return res.next

def solve(head):
    l1 = head
    prev, mid = getMiddleNode(head)
    prev.next = None
    l2 = reverse(mid)
    return reorder(l1, l2)

def printList(head):
    while head is not None:
        print(head.data, end=' ')
        head = head.next

head1 = ListNode(1)
head1.next = ListNode(2)
head1.next.next = ListNode(3)
head1.next.next.next = ListNode(4)
head1.next.next.next.next = ListNode(5)
#printList(head1)

"""head2 = ListNode(5)
head2.next = ListNode(6)
head2.next.next = ListNode(7)"""
#printList(head2)

printList(solve(head1))