package week01.lesson01;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) return;
        int index = -1;
        if(m == 0) {
            for(int i : nums2){
                index++; nums1[index] = i;
            }
            return;
        }
        int n1 = m; int n2 = n; int count = nums1.length - 1;
        while (n1 > 0 || n2 > 0){
            if(n1 == 0){nums1[count] = nums2[n2-1]; count --; n2--;}
            else if(n2 == 0) break;
            else {
                if (nums2[n2 - 1] > nums1[n1 - 1]) {
                    nums1[count] = nums2[n2 - 1];count--;n2--;
                } else if (nums2[n2 - 1] == nums1[n1 - 1]) {
                    nums1[count] = nums2[n2 - 1];
                    count--;
                    nums1[count] = nums1[n1 - 1];count--;
                    n2--;n1--;
                } else {
                    nums1[count] = nums1[n1 - 1];count--;n1--;
                }
            }
        }
    }
}
