class Solution {
    int output = 0;

    public int sumK(Node root, int k) {
        ArrayList<Integer> paths = new ArrayList<>();
        sumKUtils(root, k, paths);
        return output;
    }

    void sumKUtils(Node root, int k, ArrayList<Integer> paths) {
        if (root == null) 
            return;

        paths.add(root.data);
        int sum = 0;

        for (int i = paths.size() - 1; i >= 0; --i) {
            sum += paths.get(i);
            if (sum == k) {
                ++output;
            }
        }

        sumKUtils(root.left, k, paths);
        sumKUtils(root.right, k, paths);

        paths.remove(paths.size() - 1);
    }
}
