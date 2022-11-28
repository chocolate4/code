package week07;

public class Work01 {
    public static void main(String[] args) {
        new Work01().canJump1(new int[]{3,2,1,0,4});
    }
    public boolean canJump(int[] nums) {
        int l = nums.length;
        boolean[] res = new boolean[l];
        res[0] = true;
        for(int i = 0; i < l; i++){
            if(res[i] == true) { //todo 如果节点不能到达，那么也不会从次节点开始跳跃
                for (int j = 0; j <= nums[i]; j++) {
                    if(i+j == l) break;
                    res[i + j] = true;
                }
            }
        }
        return res[l-1];
    }

    public boolean canJump1(int[] nums) {
        int res = 0; //todo 能跳到的最远距离
        boolean flag = false;
        for(int i = 0; i <= res; i++){  //todo 随时更新可跳跃到的位置
            res = Math.max(i+nums[i],res);
            if(res >= nums.length - 1) {flag = true; break;} //todo 发现可以跳到则退出循环
        }
        return flag;
    }
}
