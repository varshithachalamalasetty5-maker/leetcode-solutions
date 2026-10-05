class Solution {
    int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // Last element in postorder is the root
        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = left;
        while (inorder[index] != rootValue) {
            index++;
        }

        // Build right subtree first
        root.right = build(inorder, postorder, index + 1, right);

        // Build left subtree
        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}