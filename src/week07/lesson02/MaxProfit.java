package week07.lesson02;

/**
 * 714 含手续费
 */
public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        //todo 0.将索引移至1开始
        int[] copy = new int[prices.length+1];
        copy[0] = 0;
        for(int i = 0; i < prices.length; i++){
            copy[i+1] = prices[i];
        }

        //todo 1.定义 res 初始化所有值为 负无穷
        final int[][] res = new int[prices.length + 1][2];
        for(int i = 0; i < prices.length + 1; i++){
            for(int j = 0; j < 2; j++){
                res[i][j] = Integer.MIN_VALUE;
            }
        }
        res[0][0] = 0;
        //todo 2.循环所有的状态
        for(int i = 1; i <= prices.length; i++){
            //todo 3.输入公式
            res[i][0] = Math.max(res[i][0],res[i-1][1] + copy[i]); //卖
            res[i][1] = Math.max(res[i][1],res[i-1][0] - copy[i] -fee); //买
            for(int j = 0; j < 2; j++){
                res[i][j] = Math.max(res[i][j],res[i-1][j]);
            }
        }
        //todo 4.返回结果
        return res[prices.length][0];
    }
}
