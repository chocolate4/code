package week05;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Work02 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Work02().solve(board);
//        System.out.println(board[1][2]);
    }

    int m;
    int n;
    boolean[][] visited;
    Queue<Pair<Integer,Integer>> queue;

    public void solve(char[][] board) {
        m = board.length; //行
        n = board[0].length; //列
        visited = new boolean[m][n]; //状态数组
        queue = new ArrayDeque<>(m*n);
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                //todo 没有被访问过的 O
                if(visited[i][j] == false && board[i][j] == 'O'){
                    dfs(i,j,board);
                }
            }
        }
    }

    public void dfs(int i, int j,char[][] board){
        int[] dx = {-1,0,0,1}; //方向数组
        int[] dy = {0,1,-1,0}; //方向数组
        queue.add(new Pair<>(i,j));
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>(); //记录
        Boolean flag = true;
        while (!queue.isEmpty()){
            int mm = queue.peek().getKey();
            int nn = queue.poll().getValue();
            pairs.add(new Pair<>(mm,nn));
            for(int o = 0; o < 4; o++){
                int mx = mm + dx[o];
                int ny = nn + dy[o];
                if(mx < 0 || mx >= m || ny < 0 || ny >= n) continue;
                if(visited[mx][ny] == true) continue;
                if(board[mx][ny] == 'X') continue;
//                if(mx == 0 || mx == m || ny == 0|| ny == n) flag = false;
                queue.add(new Pair<>(mx,ny));
                pairs.add(new Pair<>(mx,ny));
                visited[mx][ny] = true;
            }
        }
        //todo 判断O 是否在边界
        for(Pair p : pairs){
            if((int) p.getKey() == 0 || (int) p.getKey() == m-1) flag = false;
            if((int) p.getValue() == 0 || (int) p.getValue() == n-1) flag = false;
        }
        //todo 修改
        if(flag == true){
            for(Pair p : pairs){
                board[(int) p.getKey()][(int) p.getValue()] = 'X';
            }
        }
    }
}
