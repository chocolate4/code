package week06.lesson04;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];
        results[0] = nums[0];
        for(int i = 1; i < n; i++){
            results[i] = Math.max(results[i-1] + nums[i],nums[i]);
        }
        return Arrays.stream(results).max().getAsInt();
    }
}
