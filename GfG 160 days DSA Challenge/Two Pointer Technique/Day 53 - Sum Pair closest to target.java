class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return new ArrayList<>();
        }

        Arrays.sort(arr);
        int n = arr.length;
        int closestSum = Integer.MAX_VALUE;
        int maxDifference = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            // Update closest sum
            if (Math.abs(sum - target) < Math.abs(closestSum - target) ||
                (Math.abs(sum - target) == Math.abs(closestSum - target) && 
                (arr[right] - arr[left] > maxDifference))) {
                closestSum = sum;
                maxDifference = arr[right] - arr[left];
                result = Arrays.asList(arr[left], arr[right]);
            }

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                break;
            }
        }

        return result;
    }
}
