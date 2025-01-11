class Solution {
    public int longestUniqueSubstr(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[256];
        
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int start = 0;
        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            if (lastIndex[currentChar] >= start) {
                start = lastIndex[currentChar] + 1;
            }

            lastIndex[currentChar] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
