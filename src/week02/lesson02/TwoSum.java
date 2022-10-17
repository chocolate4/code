package week02.lesson02;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int[] ints1 = new TwoSum().twoSum(ints, 9);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            map.put(target-nums[i],i);
        }
        return result;
    }
}
