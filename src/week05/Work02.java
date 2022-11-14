package week05;

import com.sun.jmx.remote.internal.ArrayQueue;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

public class Work02 {
    public static void main(String[] args) {
        boolean[][] visited1 = new boolean[1][1];
        System.out.println(visited1[0][0]);
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Work02().solve(board);
//        System.out.println(board[1][2]);
    }

    int m;
    int n;
    boolean[][] visited;
    Queue<Pair<Integer,Integer>> queue;
    ArrayList<ArrayList<Pair<Integer,Integer>>> ans;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        queue = new ArrayDeque<>(m*n);
        ans = new ArrayList<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && board[i][j] == 'O'){
                    dfs(i,j,board);
                }
            }
        }
    }

    public void dfs(int i, int j,char[][] board){
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        queue.add(new Pair<>(i,j));
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
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
        for(Pair p : pairs){
            if((int) p.getKey() == 0 || (int) p.getKey() == m-1) flag = true;
            if((int) p.getValue() == 0 || (int) p.getValue() == n-1) flag = true;
        }
        if(flag == true){
            ans.add(new ArrayList<>(pairs));
        }
    }
}
