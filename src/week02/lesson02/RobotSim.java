package week02.lesson02;

import com.oracle.tools.packager.Log;

import java.util.HashSet;

public class RobotSim {
    public static void main(String[] args) {
        new RobotSim().robotSim(new int[]{4,-1,4,-2,4},new int[][]{{2,4}});
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        //todo：1.存储障碍物的位置
        HashSet<Long> ob = new HashSet<>();
        for(int[] obstacle : obstacles){
            ob.add(location(obstacle));
        }
        int x = 0; int y = 0;
        int max = 0;
        //todo：2.方向标识+方向数组
        int dir = 0; // 0=N,1=E,2=S,W=3
        int[] dx = new int[]{0,1,0,-1}; //x方向
        int[] dy = new int[]{1,0,-1,0}; //y方向
        for(int c : commands){
            if(c == -1){
                dir = (dir+1)%4; //右转
            }else if(c == -2){
                dir = (dir-1+4)%4; //左转
            }else {
                for(int i = 0; i < c; i++){
                    if(ob.contains((x+dx[dir]+30000)*60001L+(y+dy[dir]+30000))) break;
                    x = x + dx[dir];
                    y = y + dy[dir];
                }
                //todo：3.选取最大值
                max = Math.max((x*x + y*y),max);
            }
        }
        return max;
    }

    public Long location(int[] obstacle){
        return (obstacle[0]+30000) * 60001L + (obstacle[1]+30000);
    }
}
