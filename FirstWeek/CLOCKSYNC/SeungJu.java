import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;

public class Main {
        static int ans = 1000000000;
        public static void main(String args[]) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine().trim());
                switches[0] = new int[]{0,1,2};
                switches[1] = new int[]{3,7,9,11};
                switches[2] = new int[]{4,10,14,15};
                switches[3] = new int[]{0,4,5,6,7};
                switches[4] = new int[]{6,7,8,10,12};
                switches[5] = new int[]{0,2,14,15};
                switches[6] = new int[]{3,14,15};
                switches[7] = new int[]{4,5,7,14,15};
                switches[8] = new int[]{1,2,3,4,5};
                switches[9] = new int[]{3,4,5,9,13};
                for(int t=0;t<T;t++) {
                       check = new int[16];
                       map = new int[16];
                        ans = 1000000000;
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        for(int i=0;i<16;i++){
                                map[i] = Integer.parseInt(stk.nextToken());
                        }
                        go(0,0);
                        if(ans == 1000000000){
                                System.out.println(-1);
                        }
                        else
                                System.out.println(ans);
                }
        }
        static int[] check;
        static int[] map;
        static int[][] switches = new int[10][5];
        public static void go(int index,int sum){
                if(index == 10){
                        for(int i=0;i<16;i++){
                                if(map[i]!=12) return;
                        }
                        ans = Math.min(ans,sum);
                        return;
                }
                check[index] = 1;
                rotateCW(index);
                go(index+1,sum+1);
                check[index] = 2;
                rotateCW(index);
                go(index+1,sum+2);
                check[index] = 3;
                rotateCW(index);
                go(index+1,sum+3);
                check[index] = 0;
                rotateCCW(index);
                rotateCCW(index);
                rotateCCW(index);
                go(index+1,sum);
        }
        public static void rotateCW(int index){
                for(int i=0;i<switches[index].length; i++){
                        map[switches[index][i]] += 3;
                        if(map[switches[index][i]]==15){
                                map[switches[index][i]]=3;
                        }
                }
        }
        public static void rotateCCW(int index){
                for(int i=0;i<switches[index].length; i++){
                        map[switches[index][i]] -= 3;
                        if(map[switches[index][i]]==0){
                                map[switches[index][i]]=12;
                        }
                }
        }
}

