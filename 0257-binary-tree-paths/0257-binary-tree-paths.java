class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);

        return result;
    }

    public void findPaths(TreeNode root, String path,
                          List<String> result) {

        if (root == null) {
            return;
        }

        path += root.val;

        // Check whether the node is a leaf
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        path += "->";

        findPaths(root.left, path, result);

        findPaths(root.right, path, result);
    }
}