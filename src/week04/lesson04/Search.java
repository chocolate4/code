package week04.lesson04;

public class Search {

    public static void main(String[] args) {
        System.out.println(new Search().search1(new int[]{-1,0,3,5,9,12},9));
        System.out.println(new Search().search2(new int[]{-1,0,3,5,9,12},9));
        System.out.println(new Search().lowerBound(new int[]{-1,0,3,5,9,12},8));
        System.out.println(new Search().upperBound(new int[]{-1,0,3,5,9,12},8));
    }

    public int search1(int[] nums, int target) {
        int r = 0;
        int l = nums.length-1;
        int mid;
        int result = -1;
        while (r <= l){
            mid = (l-r)/2 + r;
            if(nums[mid] == target) {result = mid; break;}
             if(nums[mid] < target){
                r = mid+1;
            }else {
                l = mid -1;
            }
        }
        return result;
    }

    public int search2(int[] nums, int target) {
        this.nums = nums;
        return find(0,nums.length-1,target);
    }

    int[] nums;

    private int find(int left,int right,int target){
        int mid = (left-right)/2 + right;
        if(left > right) return -1;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target){
            return find(left,mid-1,target);
        }else{
            return find(mid + 1,right,target);
        }
    }

    //第一个大于等于target
    public int lowerBound(int[] nums,int target){
        this.nums = nums;
        return find1(0,nums.length-1,target);
    }

    private int find1(int left,int right,int target){
        int mid = (left-right)/2 + right;
        if(left == right) return left;
//        if(left == right-1) return Math.max(target-right,target-left);
        if(nums[left] >= target) return left;
        if(nums[mid] >= target){
            return find1(left,mid,target);
        }else{
            return find1(mid+1,right,target);
        }
    }

    public int upperBound(int[] nums,int target){
        this.nums = nums;
        return find2(0,nums.length-1,target);
    }

    private int find2(int left,int right,int target){
        int mid = (left-right)/2 + right;
        if(left == right) return left;
//        if(left == right-1) return Math.max(target-right,target-left);
        if(nums[right] <= target) return right;
        if(nums[mid] > target){
            return find2(left,mid-1,target);
        }else{
            return find2(mid,right,target);
        }
    }
}
