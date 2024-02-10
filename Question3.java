// Given a collection of numbers, nums, that might contain duplicates, return all possible permutation in any order.
// Input:
// nums = [1,1,2]  
// Output:
// [[1,1,2], [1,2,1], [2,1,1]] 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question3 {

    public void backtrack(List<List<Integer>> ans, List<Integer> permutation, int[] nums, boolean[] visited) {
        if (permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            backtrack(ans, permutation, nums, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    public static void main(String[] args) {
        Question3 q = new Question3();
        int[] arr = {1, 1, 2};
        List<List<Integer>> result = q.permuteUnique(arr);
        System.out.println(result);
    }
}
