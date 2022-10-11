package week01.lesson01;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[index] == nums[i]){
                continue;
            }else{
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }
}
