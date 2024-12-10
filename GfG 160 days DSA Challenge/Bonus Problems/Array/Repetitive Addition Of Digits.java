class Solution {
    public int singleDigit(int n) {
        // Use the concept of digital root
        if (n == 0) return 0;
        if (n % 9 == 0) return 9;
        return n % 9;
    }
}