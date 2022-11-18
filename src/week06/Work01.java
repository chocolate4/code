package week06;

/**
 * 70. n = (n-1) + (n-2)
 */
public class Work01 {

    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] opt = new int[n];
        opt[0] = 1;
        opt[1] = 2;
        for(int i = 1; i < n; i++){
            //todo 同类子问题
            opt[i] = opt[i-1] + opt[i-2];
        }
        return opt[n-1];
    }
}
