public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Create prefix product array
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Step 2: Create suffix product and compute result in-place
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }

        return output;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
