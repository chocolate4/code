package week02.lesson05;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        new Permute().permute(new int[]{1,2,3});
    }


    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Boolean[] bool;

    public List<List<Integer>> permute(int[] nums) {
        bool = new Boolean[nums.length];
        for(int i = 0 ; i < bool.length; i++){
            bool[i] = false;
        }
        r(nums,0);
        return ans;
    }

    public void r(int[] nums, int n){
        if(n == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!bool[i]){
                temp.add(nums[i]);
                bool[i] = true;
                r(nums,n+1);
                bool[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
