class Solution {
    public static int findPages(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }

        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean isFeasible(int[] arr, int k, int maxPages) {
        int studentsRequired = 1;
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                studentsRequired++;
                currentPages = pages;
                if (studentsRequired > k) {
                    return false;
                }
            } else {
                currentPages += pages;
            }
        }

        return true;
    }
}
