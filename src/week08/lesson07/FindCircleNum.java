package week08.lesson07;

public class FindCircleNum {
    public static void main(String[] args) {
        new FindCircleNum().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}});
    }
    int[] fa;
    public int findCircleNum(int[][] isConnected) {
        //todo MakeSet
        int n = isConnected.length;
        fa = new int[n];
        for(int i = 0; i < n; i++){fa[i] = i;}
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //todo 符合条件则UnionSet
                if(isConnected[i][j] == 1) UnionSet(i,j);
            }
        }
        int count = 0;
        //todo 统计
        for(int i = 0; i < n; i++){
            if(fa[i] == i) count++;
        }
        return count;
    }

    public void UnionSet(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) fa[x] = y;
    }

    public int find(int x){
        if(x == fa[x]) return x;
        x = fa[x]; //todo 找到父亲
        return fa[x] = find(x);
    }
}
