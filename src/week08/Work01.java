package week08;

public class Work01 {
    int[] fa;
    public int[] findRedundantConnection(int[][] edges) {
        //todo makeSet
        int n = edges.length;
        fa = new int[n+1];
        int[] ans = new int[2];
        for(int i = 0; i < n+1; i++){fa[i] = i;}
        //todo unset
        for(int i = 0; i < n; i++){
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);
            //todo 发现成环直接break
            if(x == y) {ans[0] = edges[i][0]; ans[1] = edges[i][1]; break;}
            fa[y] = x;
        }
        return ans;
    }

    private int find(int x){
        if(fa[x] == x){return x;}
        x = fa[x];
        return fa[x] = find(x);
    }
}
