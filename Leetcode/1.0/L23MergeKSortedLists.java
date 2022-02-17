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

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Pair23{
    int data;
    ListNode node;
    
    Pair23(int data, ListNode node){
        this.data = data;
        this.node = node;
    }
}

class L23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        
        if(k == 0){
            return null;
        }
        
        if(k == 1){
            return lists[0];
        }
        
        PriorityQueue<Pair23> pq = new PriorityQueue<>( (p1, p2) -> p1.data - p2.data);
        ListNode dummy = new ListNode(-9999999), runner = dummy;
        for(int i=0; i<k; i++){
            if(lists[i] == null){
                continue;
            }
            Pair23 pair = new Pair23(lists[i].val, lists[i]);
            pq.add(pair);
        }
                
        while(!pq.isEmpty()){
            Pair23 pair = pq.poll();
            runner.next = new ListNode(pair.data);
            runner = runner.next;
            if(pair.node != null && pair.node.next != null){
                pair.data = pair.node.next.val;
                pair.node = pair.node.next;
                pq.add(pair);
            }
        }
        return dummy.next;
    }
}