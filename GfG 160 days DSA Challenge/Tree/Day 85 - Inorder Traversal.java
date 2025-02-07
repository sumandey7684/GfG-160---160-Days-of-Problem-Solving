class Solution {
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        // Traverse left subtree
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        // Process nodes
        while (!st.isEmpty()) {
            Node tmp = st.pop();
            ans.add(tmp.data);
            // Traverse right subtree
            if (tmp.right != null) {
                tmp = tmp.right;
                while (tmp != null) {
                    st.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
        return ans;
    }
}
