class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
