class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) return head;

        Node temp = head;
        while (temp != null) {
            Node n = new Node(temp.data);
            n.next = temp.next;
            temp.next = n;
            temp = n.next;
        }

        temp = head;
        Node head2 = temp.next;
        while (temp != null) {
            if (temp.random == null) {
                temp.next.random = null;
            } else {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            Node temp2 = temp.next;
            temp.next = temp2.next;
            if (temp2.next != null) {
                temp2.next = temp2.next.next;
            }
            temp = temp.next;
        }

        return head2;
    }
}
