package week08.lesson01;

public class NetworkDelayTime {
    public static void main(String[] args) {
        new NetworkDelayTime().networkDelayTime(new int[][]{{1,2,1},{2,1,3}},2,2);
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        //todo 1.创建存储n个点的数组
        int[] dist = new int[n+1];
        //todo 2.赋值
        for(int i = 0; i < n+1; i++){
            dist[i] = 100000000;
        }
        //todo 3.起始点
        dist[k] = 0;
        //todo 4.Bellman_ford算法
        //todo n-1次循环 dist[x] + z > dist[y] => dist[y] = dist[x] + z
        for(int i = 0; i < n-1; i++){
            for(int[] jot : times){
                int x = jot[0];
                int y = jot[1];
                int z = jot[2];
                if(dist[x] + z < dist[y]){
                    dist[y] = dist[x] + z;
                }
            }
        }
        //todo 5.找出最远的点
        int anx = 0;
        for(int i = 1; i < n+1; i++){
            anx = Math.max(anx,dist[i]);
        }
        return anx == 100000000 ? -1 : anx;
    }
}
