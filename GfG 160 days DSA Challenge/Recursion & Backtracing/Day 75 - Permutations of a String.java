class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtrack(res, new StringBuilder(), chars, used);
        return res;
    }

    private static void backtrack(ArrayList<String> res, StringBuilder curr, char[] chars, boolean[] used) {
        if (curr.length() == chars.length) {
            res.add(curr.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && used[i - 1])) {
                continue;
            }
            curr.append(chars[i]);
            used[i] = true;
            backtrack(res, curr, chars, used);
            curr.deleteCharAt(curr.length() - 1);
            used[i] = false;
        }
    }
}