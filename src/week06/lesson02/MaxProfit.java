package week06.lesson02;

/**
 * 122
 */

//todo 策略 往后多看一天 当我空仓时：第二天涨我就买 当我有仓位时：第二天跌我就卖
public class MaxProfit {
    public static void main(String[] args) {
        new MaxProfit().maxProfit1(new int[]{7,1,5,3,6,4});
    }
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            ans+=Math.max(prices[i] - prices[i-1],0);
        }
        return ans;
    }

    public int maxProfit1(int[] prices) {
        int ans = 0;
        Boolean flag = true;
        for(int i = 1; i < prices.length; i++){
           if(flag = true){
               if(prices[i] >= prices[i-1]){
                   flag = false;
                   ans+=(prices[i] - prices[i-1]);
               }
           }else{
               if(prices[i] < prices[i-1]) {
                   flag = true;
               }
           }
        }
        return ans;
    }
}
