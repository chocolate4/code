package week01.lesson01;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        //todo : 过滤非零
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        //todo : 补零
        for(int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
