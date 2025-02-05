class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // Base case: if the node is null, return -1
        if (node == null) {
            return -1;
        }
        // Recursive call to find the height of left and right subtrees
        int lheight = height(node.left);
        int rheight = height(node.right);

        // Return the maximum height of the two subtrees + 1
        return Math.max(lheight, rheight) + 1;
    }
}
