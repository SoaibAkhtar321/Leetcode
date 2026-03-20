/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);

        while(lengthA>lengthB){
           lengthA--;
           headA = headA.next;
        }
        while(lengthB>lengthA){
            lengthB--;
            headB= headB.next;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;


    }
    private int getListLength(ListNode head){
    int len = 0;
    while(head != null){
        len++;
        head = head.next;
    }
    return len;
}
}