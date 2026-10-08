class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxGain(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));

        int current = node.val + left + right;

        maxSum = Math.max(maxSum, current);

        return node.val + Math.max(left, right);
    }
}