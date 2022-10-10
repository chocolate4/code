package week01;

/**
 * 加一
 */
public class work01 {

    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int count = 0;
        int length = digits.length;
        for(int i = length - 1; i >= 0; i--){
            if(digits[i] == 9){
                count++;
            }
            if(flag == true){
                if (digits[i] != 9) {
                    digits[i] = digits[i] + 1;
                    break;
                }else {
                    digits[i] = 0;
                }
            }else {
                if (digits[i] != 9) {
                    digits[i] = digits[i] + 1;
                    break;
                }else {
                    digits[i] = 0;
                    flag = true;
                }
            }
        }
        //特殊情况 如 {9,9,9} 需要创建新数组，在此判断一下
        if(count == length){
            int[] ints = new int[length + 1];
            ints[0] = 1;
            for (int i = 0; i < length; i++){
                ints[i+1] = digits[i];
            }
            return ints;
        }else{
            return digits;
        }
    }
}
