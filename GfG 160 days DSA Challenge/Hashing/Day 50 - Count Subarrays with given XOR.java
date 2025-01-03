class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> prefixXorCount = new HashMap<>();
        int xor = 0;
        long count = 0;

        for (int num : arr) {
            xor ^= num;

            if (xor == k) {
                count++;
            }

            int target = xor ^ k;
            count += prefixXorCount.getOrDefault(target, 0);

            prefixXorCount.put(xor, prefixXorCount.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
