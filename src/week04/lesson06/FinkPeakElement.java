package week04.lesson06;

/**
 * 162 三分查找
 */
public class FinkPeakElement {
    public static void main(String[] args) {
//        System.out.println(1/3*2+1);
        new FinkPeakElement().findPeakElement(new int[]{1,2,3,1});
    }
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int lmid = 0;
        int rmid = 0;
        while (lmid < rmid) {
            lmid = start + (end - start) / 3; //todo 取三分之一点
            rmid = end - (end - start) / 3 ; //todo 取三分之二点
            if (nums[lmid] <= nums[rmid]) {
                start = lmid + 1;
            } else {
                end = rmid - 1;
            }
        }
        return lmid;
    }
}
