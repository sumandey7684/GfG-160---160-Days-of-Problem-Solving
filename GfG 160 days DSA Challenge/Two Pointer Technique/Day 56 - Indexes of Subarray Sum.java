class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        int left = 0, right = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum >= target) {
                right = i;
                while (sum > target && left < right) {
                    sum -= arr[left];
                    left++;
                }
                if (sum == target) {
                    ans.add(left + 1);
                    ans.add(right + 1);
                    return ans;
                }
            }
        }

        ans.add(-1);
        return ans;
    }
}
