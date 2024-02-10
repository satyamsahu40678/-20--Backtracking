// Q4. Check if the product of some subset of an array is equal to the target value.
// Input :
// n = 5 , target = 16  
// Array = [2 3 2 5 4]  
// Here the target will be equal to 2x2 x4 = 16  
// Output : 
// YES

public class Question4 {

    public static boolean isSubsetProductEqualToTarget(int[] nums, int target) {
        return backtrack(nums, 0, 1, target);
    }

    public static boolean backtrack(int[] nums, int index, int product, int target) {
        if (product == target) {
            return true;
        }

        if (index == nums.length || product > target) {
            return false;
        }

        // Include the current number in the subset product
        if (backtrack(nums, index + 1, product * nums[index], target)) {
            return true;
        }

        // Exclude the current number from the subset product
        if (backtrack(nums, index + 1, product, target)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 5, 4};
        int target = 16;
        System.out.println(isSubsetProductEqualToTarget(nums, target) ? "YES" : "NO");
    }
}

