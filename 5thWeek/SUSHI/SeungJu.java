import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());
                for(int t=1;t<=T;t++) {
                        StringTokenizer stk = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(stk.nextToken());
                        int m = Integer.parseInt(stk.nextToken())/100;
                        Item[] items = new Item[n+1];
                        for(int i=1;i<=n;i++){
                                stk = new StringTokenizer(br.readLine());
                                items[i] =new Item();
                                items[i].price = Integer.parseInt(stk.nextToken())/100;
                                items[i].favor = Integer.parseInt(stk.nextToken());
                        }
                        final  int ff = 10000;
                        long[] dp = new long[ff+1];
                        Arrays.fill(dp,-1);
                        for(int j=1;j*items[1].price<=ff;j++){
                                dp[j*items[1].price] = items[1].favor*j;
                        }
                        dp[0] = 0;
                        for(int i=2;i<=n;i++){
                                for(int j=0;j<=ff;j++){
                                        if(dp[j]!=-1){
                                                for(int k=1;j+k*items[i].price<=ff;k++){
                                                        dp[j+k*items[i].price] = Math.max(dp[j+k*items[i].price],
                                                                dp[j] + items[i].favor*k);
                                                }
                                        }
                                }
                        }
                        long ans = 0;
                        long[] maxs = new long[ff+1];
                        long maxss = 0 ;
                        for(int i=0;i<=ff;i++){
                                maxss = Math.max(maxss,dp[i]);
                                maxs[i] = maxss;
                        }
                        for(int i=1;i<=ff;i++){
                                long div = m/i;
                                int mod = m%i;
                                long value = div*dp[i] + maxs[mod];
                                ans = Math.max(ans,value);
                        }
                        System.out.println(ans);
                }
        }
        public static class Item{
                public int price,favor;
        }
}
