import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                            List<Integer> current,
                            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate numbers at the same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // If current number is greater than target,
            // no further numbers can work because array is sorted
            if (candidates[i] > target) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            // i + 1 because each number can be used only once
            backtrack(candidates, target - candidates[i],
                      i + 1, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}