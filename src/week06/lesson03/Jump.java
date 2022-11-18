package week06.lesson03;


/**
 * 55
 */
//todo 策略：往后看一步 看看下一步能跳到哪儿，选择最远的哪个
public class Jump {
    public static void main(String[] args) {
        new Jump().Jump(new int[]{2,3,1,1,4});
    }
    public int Jump(int[] nums) {
        int ans = 0;
        for(int i = 1; i < nums.length; i++){
            int max = 0;
            for(int j = 1; j < nums[i-1]; j++){
                int index = i-1;
                if(j+i-1 >= nums.length-1) {ans+=1; break;}
                index+=j;
                index += nums[j+i-1];
                max = Math.max(index,max);
                if(max >= nums.length-1) {ans+=1; break;}
            }
            ans+=1;
            i = max;
        }
        return ans;
    }
}
