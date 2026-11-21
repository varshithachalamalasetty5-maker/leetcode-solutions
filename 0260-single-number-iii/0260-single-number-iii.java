class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        // Step 1: XOR all numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find the rightmost set bit
        int bit = xor & (-xor);

        int num1 = 0;
        int num2 = 0;

        // Step 3: Divide numbers into two groups
        for (int num : nums) {

            if ((num & bit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}