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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-2);

        ListNode temp1 = odd;
        ListNode temp2 = even;
        ListNode temp = head;
        int count = 1;

        while( temp != null){
            if( (count %2) != 0){
                temp1.next = temp;
                temp1 = temp1.next;
            }else{
                temp2.next = temp;
                temp2 = temp2.next;
            }
            count++;
            temp = temp.next;
        }

        temp2.next = null;
        temp1.next = even.next;
        return odd.next;

    }
}