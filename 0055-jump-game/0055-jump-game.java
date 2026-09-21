class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is unreachable
            if (i > farthest) {
                return false;
            }

            // Update the farthest reachable position
            farthest = Math.max(farthest, i + nums[i]);

            // Already reached the end
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}