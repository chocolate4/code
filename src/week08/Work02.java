package week08;

import java.util.HashSet;
import java.util.Set;

public class Work02 {
    int[] fa;
    int n;
    int m;
    public int numIslands(char[][] grid) {
        //todo 创建方向数组
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};
        n = grid.length;
        m = grid[0].length;
        //todo makeSet
        fa = new int[m*n];
        for(int i = 0; i < m*n; i++){fa[i] = i;}
        //todo 走格子
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '0') continue; //todo 跳过
                for(int k = 0; k < 2; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue; //todo 出界了
                    //todo 建立关系
                    if(grid[nx][ny] == '1') unionSet(num(i,j),num(nx,ny));
                }
            }
        }
        //todo 统计集合个数
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '0') continue;
                if(num(i,j) == find(fa[num(i,j)])) count++;
            }
        }
        return count;
    }

    private int find(int x){
        if(fa[x] == x) return x;
        x = fa[x];
        return fa[x] = find(x);
    }

    private void unionSet(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) fa[x] = y;
    }

    private int num(int x, int y){
        return y * n + x;
    }
}
