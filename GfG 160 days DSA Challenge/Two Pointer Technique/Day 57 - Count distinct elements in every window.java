class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());
        for (int i = k; i < arr.length; i++) {
            int outgoing = arr[i - k];
            map.put(outgoing, map.get(outgoing) - 1);
            if (map.get(outgoing) == 0) {
                map.remove(outgoing);
            }
            int incoming = arr[i];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);
            result.add(map.size());
        }

        return result;
    }
}
