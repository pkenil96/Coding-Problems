package linkedList;

class ListNode <T>{
	int data;
	ListNode next;

	public ListNode(int data){
		this.data = data;
	}
}

class ReverseLinkedList{

	public static ListNode ReverseLinkedListUtil(ListNode head){
		if(head == null) return null;

		ListNode curr = head, prev = null, next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void printLinkedList(ListNode head){
		if(head == null) return;
		while(head != null){
			System.out.print(head.data+"-->");
			head = head.next;
		}
		System.out.println("null\n");
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(12);
		head.next = new ListNode(13);
		head.next.next = new ListNode(14);
		head.next.next.next = new ListNode(15);
		head.next.next.next.next = new ListNode(16);

		printLinkedList(head);
		ListNode revNode = ReverseLinkedListUtil(head);
		printLinkedList(revNode);
	}
}