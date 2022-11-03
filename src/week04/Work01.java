package week04;

public class Work01 {
    public static void main(String[] args) {
        new Work01().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},70);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length-1; // todo 行标
        int subLength = matrix[0].length-1; //todo 列标
        boolean flag = false;
        int l = 0;
        int r = length;
        int m = -1;
        while (l <= r){
            int mid = (r+l)/2;
            if(matrix[mid][subLength] < target){
                l = mid + 1;
            }
            if(matrix[mid][0] > target){
                r = mid - 1;
            }
            if(matrix[mid][subLength] >= target && matrix[mid][0] <= target) {m = mid; break;}
        }
        if(m == -1) return false;
        int l1 = 0;
        int r1 = subLength;
        System.out.println(m);
        while (l1 <= r1){
            int mid = (r1+l1)/2;
            if(matrix[m][mid] == target) {flag = true; break;}
            if (matrix[m][mid] < target){
                l1 = mid + 1;
            }
            if(matrix[m][mid] > target){
                r1 = mid - 1;
            }
        }
        System.out.println(flag);
        return flag;
    }
}
