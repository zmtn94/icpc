import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                for(int t=0;t<T;t++){
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(stk.nextToken());
                        int d = Integer.parseInt(stk.nextToken());
                        int p = Integer.parseInt(stk.nextToken());
                        int[][] edge = new int[n][n];
                        int[] edges = new int[n];
                        for(int i=0;i<n;i++){
                                stk = new StringTokenizer(br.readLine());
                                for(int j=0;j<n;j++){
                                        edge[i][j] = Integer.parseInt(stk.nextToken());
                                        edges[i] += edge[i][j];
                                }
                        }

                        double[][] dp = new double[d+1][n];
                        dp[0][p] = 1.0;
                        for(int i=1;i<=d;i++){
                                for(int j=0;j<n;j++){
                                        for(int k=0;k<n;k++){
                                                if(edge[j][k]==1){
                                          //              System.out.println(dp[i-1][k] + " "+edges[j]+" "+dp[i-1][k]/edges[j]);
                                                        dp[i][j] += dp[i-1][k]/edges[k];
                                                }
                                        }
                                }
                        }
                        int qq = Integer.parseInt(br.readLine());
                        stk = new StringTokenizer(br.readLine());

                        for(int i=0;i<qq;i++){
                                int q = Integer.parseInt(stk.nextToken());
                                System.out.print(dp[d][q]+" ");
                        }
                        System.out.println();

                }
        }
}
