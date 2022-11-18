package week06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * f[x][y]=min(f[x−1][y−1],f[x−1][y])+c[x][y]
 */
public class Work02 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] result = new int[size][size]; //创建结果空间
        result[0][0] = triangle.get(0).get(0); //填入头
        for(int i = 1; i < size; i++){
            result[i][0] = result[i-1][0] + triangle.get(i).get(0); //边界特殊值
            for(int j = 1; j < i; j++){
                result[i][j] = Math.min(result[i-1][j-1],result[i-1][j]) + triangle.get(i).get(j); //f[x][y]=min(f[x−1][y−1],f[x−1][y])+c[x][y]
            }
            result[i][i] = result[i-1][i-1] + triangle.get(i).get(i); //边界特殊值
        }
        return Arrays.stream(result[size-1]).min().getAsInt();
    }
}

//     2
//     5 6
//     11 10 13
//     15 11 18 16
//
//
//             2
//           3   4
//        6  5   5  7
//      4 1 1 8 1 8 8 3
