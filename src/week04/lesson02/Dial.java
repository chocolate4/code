package week04.lesson02;

import java.util.HashMap;
import java.util.Random;

/**
 * 骰子 1/2 1/4 1/8 ......
 */
public class Dial {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 100; i++){
            int test = new Dial().dial();
            map.put(test,map.getOrDefault(test,0)+1);
        }
        System.out.println(map);
    }
    public int dial(){
        int ans = 1;
        Random random = new Random();
        while (random.nextInt(2) == 1){
            ans++;
        }
        return ans;
    }
}
