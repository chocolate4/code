package week03.lesson04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 * 207 课程表
 */
public class CanFinish {

    HashMap<Integer, ArrayList<Integer>> map; // todo 存图
    ArrayList<Integer> visited; //todo 记录访问过的节点
    int[] inDeg; //todo 记录入度

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        inDeg = new int[numCourses];
        visited = new ArrayList<>();
        for(int[] pre : prerequisites){
            int ai = pre[0];
            int bi = pre[1];
            //todo 存图
            if(!map.containsKey(bi)){
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(ai);
                map.put(bi,integers);
            }else{
                ArrayList<Integer> integers = map.get(bi);
                integers.add(ai);
                map.put(bi,integers);
            }
            inDeg[ai]++; //todo 学习该课程的前置课程数量
        }
        Queue<Integer> q = new ArrayDeque<>();
        //todo 入读为0直接进入队列
        for(int i = 0; i < inDeg.length; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int x = q.poll();
            visited.add(x); //todo 修完了
            for(int y : map.get(x)){
                inDeg[y]--;
                if(inDeg[y] == 0){
                    q.add(y);
                }
            }
        }
        return visited.size() == numCourses;
    }
}
