class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) {
            return;
        }

        // Recursive calls to convert left and right subtrees
        mirror(node.left);
        mirror(node.right);

        // Swap the left and right subtrees
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
