class Solution {
    public Node rotate(Node head, int k) {
        int n = 0;
        Node temp1 = head;
        while (temp1 != null) {
            temp1 = temp1.next;
            n++;
        }

        k = k % n;

        if (k == 0) return head;

        Node temp2 = head;
        while (k-- > 1) {
            temp2 = temp2.next;
        }

        Node newHead = temp2.next;
        temp2.next = null;
        temp2 = newHead;

        while (temp2.next != null) {
            temp2 = temp2.next;
        }

        temp2.next = head;
        return newHead;
    }
}
