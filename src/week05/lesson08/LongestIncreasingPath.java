package week05.lesson08;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class LongestIncreasingPath {

    public static void main(String[] args) {
        int i = new LongestIncreasingPath().longestIncreasingPath(new int[][]{{0}, {1}, {5},{5}});
        System.out.println(i);
    }

    int m;
    int n;
    int[] deg; //记录入度
    String[] to; //记录出边
    int[] dist; //深度

    public int longestIncreasingPath(int[][] matrix) {
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,-1,1,0};
        m = matrix.length;
        n = matrix[0].length;
        System.out.println(m);
        System.out.println(n);
        deg = new int[m*n];
        to = new String[m*n];
        dist = new int[m*n];
        //todo 建图
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    int mx = i+dx[k];
                    int ny = j+dy[k];
                    if((mx >= 0 && mx < m && ny >= 0 && ny < n) ){
                        if(matrix[mx][ny] > matrix[i][j]) {
                            addEdge(num(i, j), num(mx, ny));
                        }
                    }
                }
            }
        }
        Queue<Integer> p = new ArrayDeque<>();
        //todo 找到入度为0的点加入队列 从入度为0的点开始找
        for(int i = 0; i < m*n; i++){
            if(deg[i] == 0){
                p.add(i);
                dist[i] = 1;
            }
        }
        while (!p.isEmpty()){
            int x = p.peek();
            p.poll();
            if(to[x] != null){ //它与谁相连
                for(String n : to[x].substring(5).split(",")){
                    int i = Integer.valueOf(n);
                    deg[i]--;
                    dist[i] = Math.max(dist[i],dist[x]+1);
                    if(deg[i] == 0) p.add(i);
                }
            }
        }
        int ans = 0;
        for(int i : dist) ans = Math.max(ans,i);
        return ans;
    }

    private void addEdge(int u, int v) {
        deg[v]++;
        to[u]+=","+v;
    }

    int num(int i, int j){
        return i * n + j;
    }
}
