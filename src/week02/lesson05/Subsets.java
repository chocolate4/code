package week02.lesson05;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1,2,3});
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        //todo : 边界
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        t.add(nums[cur]);
        dfs(cur + 1, nums);
        //todo : 还原现场
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
