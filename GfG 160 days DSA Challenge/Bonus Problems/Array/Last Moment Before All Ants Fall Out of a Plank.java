// User function Template for Java
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxLeft = 0; // Tracks the farthest left-moving ant
        int maxRight = 0; // Tracks the farthest right-moving ant

        // Calculate the farthest time for left-moving ants
        for (int l : left) {
            maxLeft = Math.max(maxLeft, l);
        }

        // Calculate the farthest time for right-moving ants
        for (int r : right) {
            maxRight = Math.max(maxRight, n - r);
        }

        // The last moment is the maximum of the two
        return Math.max(maxLeft, maxRight);
    }
}