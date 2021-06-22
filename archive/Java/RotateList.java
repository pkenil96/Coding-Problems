package leetcode;


class RotateList{

	public static void printList(ListNode head){
		if(head == null) return;
		while(head != null){
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.print("null\n");
	}

	public static int getListLength(ListNode head){
		int len = 0;
		while(head != null){
			len++;
			head = head.next;
		}
		return len;
	}


	public static ListNode RotateListUtil(ListNode head, int k){
		//rotate the list k times towards right
		int listLength = getListLength(head);

		//the quotient times shifiting will have no effect, only remainder will
		if(listLength < k)
			k %= listLength;

		if(k <= 0 || head == null || listLength == 1)
			return head;

		//if the length of the list is multiple of k, then shifting
		//it k times will have no effect on the list
		if(k != 1 && listLength%k == 0)
			return head;

		ListNode saveHead = head;

		//Traverse to the (k+1)th node from the end
		int runner = 0;

		while(head.next != null && runner != listLength - k - 1){
			head = head.next;
			runner++;
		}
		//System.out.println(head.data);
		ListNode x = head;
		ListNode y = x.next;
		x.next = null;

		ListNode yRunner = y;
		while(yRunner != null && yRunner.next != null){
			yRunner = yRunner.next;
		}	
		yRunner.next = saveHead;
		return y;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		printList(head);
		printList(RotateListUtil(head, 10));
	}
}