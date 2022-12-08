package week09.lesson01;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfSubarrays {
    public static void main(String[] args) {
        new NumberOfSubarrays().numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int l = nums.length;
        int[] temp = new int[l];
        for(int i = 0; i < l; i++){
            temp[i] = nums[i] % 2;
        }
        int[] res = new int[l+1];
        for(int i = 1; i < l+1; i++){
            res[i] = res[i-1] + temp[i-1];
        }

        int i = l;
        int c = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (l >= 0){
            map.put(res[l] - k,map.getOrDefault(res[l] - k,0) + 1);
            l--;
        }
        return c;
    }
}

