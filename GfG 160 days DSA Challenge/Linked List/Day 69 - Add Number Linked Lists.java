class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node p1 = reverse(num1), p2 = reverse(num2);
        Node newNode = new Node(-1);
        Node start = newNode;
        int carry = 0;

        while (p1 != null || p2 != null || carry > 0) {
            int sum = 0;
            if (p1 != null) {
                sum += p1.data;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.data;
                p2 = p2.next;
            }

            sum += carry;
            int numb = sum % 10;
            carry = sum / 10;

            newNode.next = new Node(numb);
            newNode = newNode.next;
        }

        Node rev = reverse(start.next);
        while (rev.data == 0) {
            rev = rev.next;
        }
        return rev;
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newNode = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newNode;
    }
}
