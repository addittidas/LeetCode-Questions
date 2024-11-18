// 61. Rotate List
/* Given the head of a linked list, rotate the list to the right by k places. */

class Q61_Rotate_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }

        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
    
        k = k % len;
        int n = len - k - 1;
        ListNode temp = head;

        while(n > 0){
            n--;
            temp = temp.next;
        }

        tail.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}