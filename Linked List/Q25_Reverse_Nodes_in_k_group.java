// 25. Reverse Nodes in k-Group
/* Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed. */

class Q25_Reverse_Nodes_in_k_group {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevlast = null;
        while(temp != null){
            ListNode kthnode = findkthnode(temp, k);
            if (kthnode == null){
                if(prevlast != null){
                    prevlast.next = temp;
                }
                break;
            }
            ListNode newnode = kthnode.next;
            kthnode.next = null;
            reverse(temp);

            if(temp == head){
                head = kthnode;
            }
            else{
                prevlast.next = kthnode;
            }
            prevlast = temp;
            temp = newnode;
        }
        return head;        
    }

    public ListNode findkthnode(ListNode temp, int k){
        k -= 1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}