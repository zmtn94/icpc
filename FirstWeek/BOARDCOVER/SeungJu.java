import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.*;

public class Main {
        static char[][] map ;
        static int[] bitmask;
        static int[][] dp;
        static int ans;
        public static void main(String args[]) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine().trim());
                for(int t=0;t<T;t++) {
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(stk.nextToken());
                        int m = Integer.parseInt(stk.nextToken());
                        map = new char[n+1][m+1];
                        ans = 0 ;
                        for(int i=1;i<=n;i++){
                                String input = br.readLine();
                                for(int j=1;j<=m;j++){
                                        map[i][j] = input.charAt(j-1);
                                }
                        }
                        go(2,1,n,m);
                        System.out.println(ans);
                }
        }
        public static void go(int row,int col,int n,int m){
                if(row == n+1 ){
                        boolean flag = true;
                        for(int i=1;i<=m;i++){
                                if(map[n][i]=='.') {
                                        flag = false;
                                        break;
                                }
                        }
                        if(flag)
                                ans+=1;
                        return;
                }
                if(col == m+1){
                        if(row>=2){
                                for(int i=1;i<=m;i++){
                                        if(map[row-1][i]=='.') return;
                                }
                        }
                        go(row+1,1,n,m);
                        return;
                }
                if(map[row][col] == '#'){
                        go(row,col+1,n,m);
                        return;
                }
                boolean flag = true;
                if(col+1<=m && map[row-1][col]=='.'&&map[row-1][col+1]=='.'){
                        map[row][col] = '#';
                        map[row-1][col] = '#';
                        map[row-1][col+1] = '#';
                        go(row, col+1, n, m);
                        map[row][col] = '.';
                        map[row-1][col] = '.';
                        map[row-1][col+1] = '.';
                        flag = false;
                }
                if(col-1>=1 && map[row-1][col]=='.'&&map[row-1][col-1]=='.'){
                        map[row][col] = '#';
                        map[row-1][col] = '#';
                        map[row-1][col-1] = '#';
                        go(row, col+1, n, m);
                        map[row][col] = '.';
                        map[row-1][col] = '.';
                        map[row-1][col-1] = '.';
                        flag = false;
                }
                if(col-1>=1 && map[row-1][col]=='.'&&map[row][col-1]=='.'){
                        map[row][col] = '#';
                        map[row-1][col] = '#';
                        map[row][col-1] = '#';
                        go(row, col+1, n, m);
                        map[row][col] = '.';
                        map[row-1][col] = '.';
                        map[row][col-1] = '.';
                        flag =false;
                }
                if(col+1<=m && map[row-1][col]=='.'&&map[row][col+1]=='.'){
                        map[row][col] = '#';
                        map[row-1][col] = '#';
                        map[row][col+1] = '#';
                        go(row, col+1, n, m);
                        map[row][col] = '.';
                        map[row-1][col] = '.';
                        map[row][col+1] = '.';
                        flag = false;
                }

                go(row, col+1, n, m);
        }
}
