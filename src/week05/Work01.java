package week05;

public class Work01 {
    public static void main(String[] args) {
        System.out.println(new Work01().countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647},-564,3864));
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int length = nums.length;
        int index = 0;
        int ans = 0;
        for (int num : nums) {
            long sum = 0;
            for(int i = index; i < length; i++){
                sum += nums[i];
                if(lower <= sum && upper >= sum){
                    ans++;
                }
            }
            index++;
        }
        return ans;
    }
}
