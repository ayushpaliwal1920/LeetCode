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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;  // important step speration yhi error ara tha

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

      

        return merge(left , right);
    }

    public ListNode merge(ListNode left , ListNode right){
        ListNode newNode = new ListNode(Integer.MIN_VALUE);
        ListNode temp = newNode;

        while(left != null && right != null){
            if(left.val <= right.val){
               temp.next = left;
               left = left.next;
            }else{
               temp.next = right;
               right = right.next;
            }

            temp = temp.next;
        }

        if(left != null){
            temp.next = left;
        }

        if(right != null){
           temp.next = right;
        }

        return newNode.next;

    } 
}