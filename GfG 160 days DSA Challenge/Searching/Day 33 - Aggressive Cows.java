// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int res = 0;
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(stalls, k, mid)) {
                res = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static boolean check(int[] stalls, int k, int dist) {
        int cnt = 1;
        int prev = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - prev >= dist) {
                prev = stalls[i];
                cnt++;
            }
        }
        return (cnt >= k);
    }
}
