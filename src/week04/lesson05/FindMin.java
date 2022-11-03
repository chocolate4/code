package week04.lesson05;

public class FindMin {
    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{4,5,6,1,2,3}));
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums.length == 1) return nums[0];
        if(nums[left] < nums[right]) return nums[0];
        while (left < right){
            int mid = (right-left)/2 + left;
            if(nums[left] > nums[mid]){
                right = mid;
            }else{
                left = mid;
            }
            if(left == right - 1) break;
        }
        return Math.min(nums[right],nums[left]);
    }

    /**
     * 4,5,6,1,2,3
     * 0,0,0,1,1,1
     */

    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (right-left)/2 + left;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[right];
    }


}
