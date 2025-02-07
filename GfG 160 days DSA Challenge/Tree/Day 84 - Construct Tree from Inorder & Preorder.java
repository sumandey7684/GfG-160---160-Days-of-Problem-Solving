class Solution {
    static int pos;
    public static Node buildTree(int inorder[], int preorder[]) {
        pos = 0; // Initialize the position for preorder traversal
        return solve(inorder, preorder, 0, inorder.length - 1);
    }
    static Node solve(int inorder[], int preorder[], int str, int end) {
        // Base case: if the start index exceeds the end index, return null
        if (str > end) {
            return null;
        }
        // Create a new node with the current preorder element
        Node root = new Node(preorder[pos]);
        int div = 0;
        // Find the index of the current node in the inorder array
        for (int i = str; i <= end; i++) {
            if (preorder[pos] == inorder[i]) {
                div = i;
                break;
            }
        }
        pos++; // Move to the next preorder element
        // Recursively build the left and right subtrees
        root.left = solve(inorder, preorder, str, div - 1);
        root.right = solve(inorder, preorder, div + 1, end);
        return root;
    }
}
