package linkedList;

class ListPalindrome{
	
	public static void print(ListNode head){
		if(head == null) return;
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode reverse(ListNode head){
		if(head == null) return head;
		ListNode cur = head, prev = null, next = null;
		while(cur != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static boolean checkIfPalindrome(ListNode head){
		if(head == null)
			return false;
		
		ListNode fast = head, slow = head;
		ListNode prevSlow = head;
		ListNode midNode = null, save = null;
		ListNode first = head, second = null;

		while(fast.next != null && fast.next.next != null){
			prevSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if(fast != null){
			midNode = slow;
			second = slow.next;
		}

		prevSlow.next = null;
		second = reverse(second);
		save = second;

		while(first != null && second != null){
			if(first.data != second.data)
				return false;
			first = first.next;
			second = second.next;
		}
		
		second = reverse(save);
		if(midNode != null){
			prevSlow.next = midNode;
			midNode.next = second;
		} else {
			prevSlow.next = second;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);
		print(head);
		System.out.println(checkIfPalindrome(head));
		print(head);	
	}
}