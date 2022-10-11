

public class Test {
    public static void main(String[] args) {
        final int[] ints = {0,1,1,0,2,0};
        new Test().moveZeroes(ints);
    }
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        for(int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
        for(int i : nums){
            System.out.println(i);
        }
    }
}
