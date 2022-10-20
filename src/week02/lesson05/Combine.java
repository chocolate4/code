package week02.lesson05;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        final List<List<Integer>> combine = new Combine().combine(2, 2);
        for(List<Integer> list : combine){
            System.out.println(list.size());
        }
    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        r(1,n,k);
        return ans;
    }

    public void r(int cur,int n, int k){
        if(temp.size() + (n-cur+1) < k){
            return;
        }

        if(temp.size() == k){
            ans.add(temp);
            return;
        }

        temp.add(cur);
        r(cur + 1,n,k);
        temp.remove(temp.size() - 1);
        r(cur + 1,n,k);
    }
}
