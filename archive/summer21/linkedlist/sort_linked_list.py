class ListNode:
	def __init__(self, data):
		self.data = data
		self.next = None


def sort_linked_list(ListNode head):
	if head is None:
		return None
		
		
head = ListNode(34)
head.next = ListNode(-12)
head.next.next = ListNode(11)
head.next.next.next = ListNode(56)
head.next.next.next.next = ListNode(4)
head.next.next.next.next.next = ListNode(54)
head.next.next.next.next.next.next = ListNode(-9)
