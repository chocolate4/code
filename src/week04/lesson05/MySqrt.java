package week04.lesson05;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(16));
    }
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right){
            int mid = (right - left)/2 + left +1; //todo 当right = mid - 1 时向上取整
            if(mid <= x/mid){ //todo 变化一下等式 防止越界
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
