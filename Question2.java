// Q2. Given an integer array arr, print all the possible permutations of the given array
// Note : The array will only contain non repeating elements. 
// Input :  
// arr = [1, 2, 3]  
// Output : 
// [[1,2,3] , [1,3,2] , [2,1,3] , [2,3,1] , [3,1,2] , [3,2,1]]

import java.util.ArrayList;
import java.util.List;

public class Question2 {

    public void backtrack(List<List<Integer>> ans, List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            permutation.add(nums[i]);
            backtrack(ans, permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(ans, new ArrayList<>(), nums); // new arraylist to make permutation

        return ans;
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = q.permute(arr);
        System.out.println(result);
    }
}
