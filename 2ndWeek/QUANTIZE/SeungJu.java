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
                        int s = Integer.parseInt(stk.nextToken());
                        int[] arr = new int[n+1];

                        stk = new StringTokenizer(br.readLine());
                        for(int i=1;i<=n;i++){
                                arr[i] = Integer.parseInt(stk.nextToken());
                        }
                        int[][][] dp = new int[n+1][s+1][1001];
                        for(int i=0;i<=n;i++){
                                for(int j=0;j<=s;j++){
                                        for(int k=0;k<=1000;k++){
                                                dp[i][j][k] = 1000000000;
                                        }
                                }
                        }
                        Arrays.sort(arr,1,n+1);
                        int min = 1000000000;
                        dp[0][0][0]=0;
                        for(int i=1;i<=n;i++){
                                for(int j=1;j<=s;j++){
                                        int subMin = 1000000000;
                                        for(int k=0;k<=1000;k++){
                                                subMin = Math.min(subMin,dp[i-1][j-1][k]);
                                        }
                                        for(int k=0;k<=1000;k++){
                                                dp[i][j][k] = Math.min(dp[i-1][j][k],subMin)+(arr[i]-k)*(arr[i]-k);
                                        }
                                }
                        }

                        for(int i=0;i<=1000;i++){
                                for(int j=1;j<=s;j++){
                                        min = Math.min(min,dp[n][j][i]);
                                }
                        }
                        System.out.println(min);
                }
        }
}
