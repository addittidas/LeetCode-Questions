// 19. Remove Nth Node From End of List
/* Given the head of a linked list, remove the nth node from the end of the list and return its head. */

// Approach 1
class Q19_Remove_Nth_Node_From_End_of_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        ListNode newhead = new ListNode();

        while(temp != null){
            len++;
            temp = temp.next;
        }

        if (len == n){
            newhead = head.next;
            return newhead;
        }

        int res = len - n;
        temp = head;

        while(temp != null){
            res--;
            if (res == 0){
                break;
            }
            temp = temp.next;
        }

        //ListNode deletenode = temp.next;
        temp.next = temp.next.next;

        return head;
    }
}

// Approach 2
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        if (fast == null){
            return head.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}