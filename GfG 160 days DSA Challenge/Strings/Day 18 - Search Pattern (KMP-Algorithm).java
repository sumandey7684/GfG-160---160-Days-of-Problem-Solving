// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int m = pat.length();
        int n = txt.length();

        // Step 1: Compute the LPS array
        int[] lps = computeLPSArray(pat);

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0; // Index for txt
        int j = 0; // Index for pat

        // Step 2: Pattern matching
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                // Match found
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String txt = "abcab";
        String pat = "ab";

        ArrayList<Integer> result = solution.search(pat, txt);
        System.out.println(result); // Output: [0, 3]
    }

}