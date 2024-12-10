class Solution {
    public boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] sortedS1 = s1.toCharArray();
        char[] sortedS2 = s2.toCharArray();
        Arrays.sort(sortedS1);
        Arrays.sort(sortedS2);
        return Arrays.equals(sortedS1, sortedS2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "listen", s2 = "silent";
        System.out.println(solution.areAnagrams(s1, s2) ? "Anagrams" : "Not Anagrams");
        s1 = "hello"; s2 = "world";
        System.out.println(solution.areAnagrams(s1, s2) ? "Anagrams" : "Not Anagrams");
    }
}
  