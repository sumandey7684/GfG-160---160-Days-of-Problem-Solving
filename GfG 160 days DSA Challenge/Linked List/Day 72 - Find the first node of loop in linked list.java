class Solution {
    public static Node findFirstNode(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        Node ptr = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
