package week09;

import java.util.HashMap;

public class Work01 {
    public int subarraySum(int[] nums, int k) {
        int l = nums.length;
        int[] res = new int[l+1];
        res[0] = 0;
        for(int i = 1; i <= l; i++){
            res[i] = res[i-1] + nums[i-1];
        }

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= l; i++) {
            if (map.containsKey(res[i] - k)) count += map.get(res[i]-k);
            map.put(res[i], map.getOrDefault(res[i], 0) + 1);
        }
        return count;
    }
}
