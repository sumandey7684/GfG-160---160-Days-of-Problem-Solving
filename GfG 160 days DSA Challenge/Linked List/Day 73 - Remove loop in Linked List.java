class Solution {
    // Function to remove a loop in the linked list
    public static void removeLoop(Node head) {
        if (head == null) {
            return;
        }

        Node fast = head;
        Node slow = head;
        Node pre = null;
        Node ptr = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;

            if (slow == fast) {
                while (ptr != slow) {
                    ptr = ptr.next;
                    pre = slow;
                    slow = slow.next;
                }
                pre.next = null;
                return;
            }
        }
    }
}
