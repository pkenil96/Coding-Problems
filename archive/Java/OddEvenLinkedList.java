package leetcode;

class OddEvenLinkedList{

	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.print("null\n");
	}
	/* 
		2->3->5->4->6->7
	 */
	public static ListNode OddEvenLinkedListUtil(ListNode head){
		if(head == null)
			return head;

		ListNode p1 = head;
		ListNode p2 = head;
		ListNode cur = head;
		while(p2 != null && p2.next != null){
			p2 = p2.next;
		}
		/*
		   cur
			2->3->5->4->6->7
			p1			   p2
		*/
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(7);
		print(head);
		print(OddEvenLinkedListUtil(head));
	}
}