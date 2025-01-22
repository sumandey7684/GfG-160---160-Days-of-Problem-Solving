class Solution {
    Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;   // Save the next node
            curr.next = prev;   // Reverse the current node's pointer
            prev = curr;        // Move the 'prev' pointer to the current node
            curr = next;        // Move to the next node in the list
        }

        return prev; // New head of the reversed list
    }
}