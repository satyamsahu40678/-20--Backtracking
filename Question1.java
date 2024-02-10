/**
 * Question1
 */
// Q1. Given an integer array arr and an integer k, return true if it is possible to divide the vector into k non-empty subsets with equal sum into k non-empty subsets
// Input:
// arr = [1,3,2,2] k = 2  
// Output:
// true  
// Explanation :
//  1 + 3 and 2+2 are two subsets with equal sum
import java.util.Arrays;
public class Question1 {    
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        if (k <= 0 || totalSum % k != 0) {
            return false;
        }
        
        int subsetSum = totalSum / k;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        
        return canPartition(nums, 0, k, 0, subsetSum, visited);
    }
    
    public static boolean canPartition(int[] nums, int start, int k, int currentSum, int targetSum, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        
        if (currentSum == targetSum) {
            return canPartition(nums, 0, k - 1, 0, targetSum, visited);
        }
        
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (canPartition(nums, i + 1, k, currentSum + nums[i], targetSum, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2};
        int k = 2;
        System.out.println(canPartitionKSubsets(arr, k));
    }
}