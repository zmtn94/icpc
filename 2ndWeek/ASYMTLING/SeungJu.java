import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                final int mod = 1000000007;
                int[] dp = new int[101];
                dp[1] = 1;
                dp[2] = 2;
                for(int i=3;i<=100;i++){
                        dp[i] = dp[i-1] + dp[i-2];
                        dp[i] %= mod;
                }
                int[] ans = {0,0,0,2,2};
                for(int t=0;t<T;t++){
                        int n = Integer.parseInt(br.readLine());
                        if(n>=1&&n<=4){
                                System.out.println(ans[n]);
                                continue;
                        }
                        if(n%2==0){
                                System.out.println((go(dp,n-1,n/2,mod)+go(dp,n-2,n/2-1,mod))%mod);
                        }
                        else{
                                System.out.println((dp[n-1]+go(dp,n-2,n/2,mod))%mod);
                        }
                }
        }
        public static int go(int[] dp ,int n,int removeNumber,int mod){
                int n1 = n-1;
                int n2 = n-2;
                if(n1==removeNumber){
                        return dp[n2];
                }
                else if(n2== removeNumber){
                        return dp[n1];
                }
                else{
                        return (dp[n1] + go(dp,n2,removeNumber,mod))%mod;
                }
        }
}
