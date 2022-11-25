package week07;

public class Work02 {
    public static void main(String[] args) {
        new Work02().jump(new int[]{1,2,3});
    }
    public int jump(int[] nums) {
        int l = nums.length;
        if(l == 1) return 0;
        if(l == 2) return 1;
        int count = 0;
        for(int i = 0; i < l-1; i++){
            if(i + nums[i] >= l-1) {count++; break;} //todo 下一步跳出去了 就可以停止循环了
            int max = i + nums[i]; //todo 临时记录变量
            int max_index = i;
            for(int j = 1; j <= nums[i]; j++){
                if(i+j + nums[i+j] > max) {max = i+j + nums[i+j]; max_index = i+j;} //todo 找到下一个能跳到最远的节点
            }
            i = max_index-1; //todo 移动索引
            count++; //todo 跳
        }
        return count;
    }
}
