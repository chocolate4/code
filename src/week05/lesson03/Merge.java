package week05.lesson03;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Merge {
    public static void main(String[] args) {
        new Merge().merge2(new int[][]{{8,10},{2,6},{1,3},{15,18}});
        new Merge().merge2(new int[][]{{1,4},{4,6},{10,12},{15,18}});
    }
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0] || o1[0] == o2[0] && o1[1] < o2[1]) return -1;
                if(o1[0] > o2[0] || o1[0] == o2[0] && o1[1] > o2[1]) return 1;
                else return 0;
            }
        });
        ArrayList<int[]> ans = new ArrayList<>();
        int start = -1;
        int max = -1;
        for(int[] interval: intervals){
            int left = interval[0];
            int right = interval[1];
            if(left <= max){
                max = Math.max(max,right);
            }else{
                if(max != -1){
                    ans.add(new int[]{start,max});
                }
                start = left;
                max = right;
            }
        }
        ans.add(new int[]{start,max});
        int[][] res = new int[ans.size()][];
        for(int i = 0 ; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    /**
     * 分差法
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for(int[] interval: intervals){
            pairs.add(new Pair(interval[0],1));
            pairs.add(new Pair(interval[1]+1,-1));
        }
        Collections.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if(o1.getKey() < o2.getKey() || (o1.getKey() == o2.getKey()) && (o1.getValue() < o2.getValue()) ) return -1;
                if(o1.getKey() > o2.getKey()) return 1;
                else return 0;
            }
        });
        int start = 0;
        int count = 0;
        ArrayList<int[]> ints = new ArrayList<>();
        for(Pair<Integer,Integer> pair : pairs){
            if(count == 0) start = pair.getKey();
            count += pair.getValue();
            if(count == 0) ints.add(new int[]{start,pair.getKey()});
//            if(start == -1){
//                start = pair.getKey();
//            }
//            count += pair.getValue();
//            if(count == 0) {
//                end = pair.getKey();
//                ints.add(new int[]{start,end});
//                start = -1;
//            }
        }
        int[][] res = new int[ints.size()][];
        for(int i = 0; i < res.length; i++){
            res[i] = ints.get(i);
        }
        return res;
    }
}
