/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

public class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers{
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int carry = 0;
        //we create a dummy node to keep track of the head node
        ListNode ansHead = new ListNode(-1);
        ListNode result = ansHead;
        while(l1 != null && l2 != null){
            int digitSum = l1.val + l2.val + carry;
            carry = 0;
            if(digitSum > 9){
                digitSum %= 10;
                carry = 1;    
            }
            ansHead.next = new ListNode(digitSum);
            ansHead = ansHead.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //in case the input numbers were of different lengths, we might
        //have to do some extra work
        while(l1 != null){
            int digitSum = l1.val + carry;
            carry = 0;
            if(digitSum > 9){
                digitSum %= 10;
                carry = 1;    
            }
            ansHead.next = new ListNode(digitSum);
            ansHead = ansHead.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            int digitSum = l2.val + carry;
            carry = 0;
            if(digitSum > 9){
                digitSum %= 10;
                carry = 1;    
            }
            ansHead.next = new ListNode(digitSum);
            ansHead = ansHead.next;
            l2 = l2.next;        
        }
        
        if(carry == 1){
            ansHead.next = new ListNode(carry);
        }
        return result.next;
    }
    
    public static void printList(ListNode head){
        if(head == null) return;
        while(head != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();       
    }

    public static void main(String [] args){
        ListNode number1 = new ListNode(9);
        number1.next = new ListNode(9);
        
        ListNode number2 = new ListNode(2);
        number2.next = new ListNode(3);
        number2.next.next = new ListNode(6);
    
        ListNode sum = addTwoNumbers(number1, number2);
        printList(sum);
    }
}
