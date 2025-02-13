class Solution {
    int maxSum = Integer.MIN_VALUE;

    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        findMaxSumHelper(node);
        return maxSum;
    }

    int findMaxSumHelper(Node node) {
        if (node == null) return 0;

        int leftMax = Math.max(0, findMaxSumHelper(node.left));
        int rightMax = Math.max(0, findMaxSumHelper(node.right));

        maxSum = Math.max(maxSum, node.data + leftMax + rightMax);

        return node.data + Math.max(leftMax, rightMax);
    }
}
