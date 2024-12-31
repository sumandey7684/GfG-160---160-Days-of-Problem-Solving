class Solution {
    // Function to return the length of the longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        Set<Integer> hst = new HashSet<>();
        for (int i : arr) {
            hst.add(i);
        }
        
        int ans = 0;
        for (int i : arr) {
            int curr = 0, tmp1 = i, tmp2 = i - 1;
            if (hst.contains(i)) {
                while (hst.contains(tmp1)) {
                    curr++;
                    hst.remove(tmp1);
                    tmp1++;
                }
                while (hst.contains(tmp2)) {
                    curr++;
                    hst.remove(tmp2);
                    tmp2--;
                }
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
