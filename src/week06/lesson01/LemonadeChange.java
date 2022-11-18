package week06.lesson01;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] nums = new int[2];
        boolean flag = true;
        for(int i : bills) {
            if (i == 5) {
                nums[0]++;
            }
            if (i == 10) {
                nums[1]++;
                if(nums[0] >= 1) nums[0]--; else flag = false;
            }
            if (i == 20) {
                if(nums[1] >= 1){
                    nums[1]--;
                    if(nums[0] >= 1) nums[0]--; else flag = false;
                }else{
                    if(nums[0] >= 3) nums[0]-=3; else flag = false;
                }
            }
        }
        return flag;
    }
}
