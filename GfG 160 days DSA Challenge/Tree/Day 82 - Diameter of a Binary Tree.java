class Solution {
    /// Solution
    int diameter(Node root) {
        // Array to store the maximum diameter
        int[] ans = new int[1];
        find(root, ans);
        return ans[0];
    }

    private int find(Node root, int[] ans) {
        // Base case
        if (root == null) return 0;

        // Recursive work
        int left = find(root.left, ans);
        int right = find(root.right, ans);

        // Update the diameter
        ans[0] = Math.max(ans[0], left + right);

        // Return the height of the current node
        return Math.max(left, right) + 1;
    }
}
