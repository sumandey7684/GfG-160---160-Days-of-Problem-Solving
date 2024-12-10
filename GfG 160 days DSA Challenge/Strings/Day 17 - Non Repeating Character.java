// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (char i : s.toCharArray()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        
        return '$';
    }
}