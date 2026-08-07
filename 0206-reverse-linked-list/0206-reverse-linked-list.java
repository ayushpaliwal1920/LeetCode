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
class Solution {
    public ListNode reverseList(ListNode head) {
    
        if(head == null || head.next == null) return head;

        ListNode smallAns = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return smallAns;

    }   
}

// using three pointer 

// Node curr = head;
// Node prev = null;
// Node agla = null;

// while( curr != null){
//     agla = curr.next;
//     curr.next = prev;
//     prev = curr;
//     curr = agla;
// }
// return prev;