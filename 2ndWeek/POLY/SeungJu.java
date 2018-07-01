import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                int mod = 10000000;
                for(int t=0;t<T;t++){
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(stk.nextToken());
                        int[][][] dp = new int[n+1][n+1][n+1];
                        for(int i=1;i<=n;i++){
                                dp[1][i][i] = 1;
                        }
                        for(int i=2;i<=n;i++){
                                for(int j=1;j<=n;j++){
                                        int[] sum =new int[n+1];
                                        int[] sum2 = new int[n+1];
                                        for(int k=1;k<=n;k++){
                                                sum[k] = sum[k-1] + dp[i-1][j][k];
                                                sum[k] %= mod;
                                                sum2[k]  = sum2[k-1] + (k)*dp[i-1][j][k];
                                                sum2[k] %= mod;
                                        }
                                        for(int k=1;k<=n;k++){
                                                if(j+k<=n){
                                                        dp[i][j+k][k] = (int)((sum[n] * (long)(k-1))%mod);
                                                        dp[i][j+k][k] += sum2[n];
                                                        dp[i][j+k][k] %= mod;
                                                }
                                        }
                                }
                        }
                        int ans = 0 ;
                        for(int i=1;i<=n;i++){
                                for(int j=1;j<=n;j++){
                                        ans  += dp[i][n][j];
                                        ans %= mod;
                                }
                        }
                        System.out.println(ans);
                }
        }
}
