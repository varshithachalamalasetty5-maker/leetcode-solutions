import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, 
                           List<Integer> current, 
                           List<List<Integer>> result) {

        // All elements are selected
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {

            // Don't use the same element twice
            if (current.contains(num)) {
                continue;
            }

            current.add(num);

            backtrack(nums, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}