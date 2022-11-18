package week06.lesson02;

import java.util.Arrays;

/**
 * 455
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int ans = 0;
        for (int child : g){
            while (j < s.length && s[j] < child) j++;
            if(j < s.length) ans++; j++;
        }
        return ans;
    }
}
