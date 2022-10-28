package week03.lesson04;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 684 冗余连接
 * 1.存储图
 * 2.深度遍历(无向图 已经走过的要做标记)
 */
public class FindRedundantConnection {

    public static void main(String[] args) {
        FindRedundantConnection findRedundantConnection1 = new FindRedundantConnection();
        findRedundantConnection1.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
    }

    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = store(edges);
        System.out.println(graph);
        return new int[]{};
    }

    /**
     * 存图
     * @param edges
     * @return
     */
    HashMap<Integer, ArrayList<Integer>> store(int[][] edges){
        map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            if(!map.containsKey(edges[i][0])){
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(edges[i][1]);
                map.put(edges[i][0],integers);
            }else{
                ArrayList<Integer> integers = map.get(edges[i][0]);
                integers.add(edges[i][1]);
                map.put(edges[i][0],integers);
            }
        }
        visited = new Boolean[map.size()];

        return map;
    }

    void dfs(int x, int fa){
        //todo 标记处理过的节点
        visited[x] = true;
        //todo 遍历节点的出边
        for(int y : map.get(x)){
            if(y == fa) continue; //todo 如果找到了它的父节点则跳过
            if(!visited[y]) dfs(y,x); //todo 深度优先遍历
            else hasCycle = true; //todo 有环
        }
    }

    int n;

    Boolean[] visited;

    HashMap<Integer, ArrayList<Integer>> map;

    Boolean hasCycle;
}
