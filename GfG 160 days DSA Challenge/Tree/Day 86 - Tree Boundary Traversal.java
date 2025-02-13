class Solution {
    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    static void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
        if (root == null) return;

        Node curr = root;
        while (!isLeaf(curr)) {
            res.add(curr.data);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    static void collectLeaves(Node root, ArrayList<Integer> res) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                if (current.right == null) {
                    res.add(current.data);
                }
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    if (predecessor.left == null) {
                        res.add(predecessor.data);
                    }
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    static void collectBoundaryRight(Node root, ArrayList<Integer> res) {
        if (root == null) return;

        Node curr = root;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!isLeaf(curr)) {
            temp.add(curr.data);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }

    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) {
            res.add(root.data);
        }

        collectBoundaryLeft(root.left, res);
        collectLeaves(root, res);
        collectBoundaryRight(root.right, res);

        return res;
    }
}
