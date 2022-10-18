package week02;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Work02 {
    public static void main(String[] args) {
        new Work02().findShortestSubArray(new int[]{1,2,2,3,1});
    }
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(!map.containsKey(nums[i])) first.put(nums[i],i);
            last.put(nums[i],i);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max = Math.max(max,map.get(nums[i]));
        }
        int length = Integer.MAX_VALUE;
        for(Integer key : map.keySet()){
            if(map.get(key) == max){
                length = Math.min(length,(last.get(key) - first.get(key)+1));
            }
        }
        System.out.println(max);
        System.out.println(length);
        return length;
    }
}
