package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;

class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        
        ListNode d = new ListNode(0);
        d.next = head;
        
        ListNode p = d;
        while(p.next != null && p.next.next != null){
            if(p.next.data == p.next.next.data){
                int duplicate = p.next.data;
                while(p.next != null && p.next.data == duplicate){
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return d.next;
    }
}