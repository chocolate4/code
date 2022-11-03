package week04.lesson05;

public class SearchRange {
    public static void main(String[] args) {
        new SearchRange().searchRange(new int[]{2,2},1);
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        if(nums.length == 1) return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] == nums[right] && nums[left] == target) return new int[]{left,right};
        int[] ints = new int[2];
        while (left < right){
            int mid = (right-left)/2+left;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        ints[0] = right;
        left = right;
        right = nums.length - 1;
        while (left < right){
            int mid = (right-left)/2+left+1; //todo 向上取整
            if(nums[mid] == target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        ints[1] = right;
        return nums[ints[0]] == target && nums[ints[1]] == target ? ints : new int[]{-1,-1};
    }
}
