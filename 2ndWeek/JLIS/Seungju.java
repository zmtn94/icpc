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
                        int m = Integer.parseInt(stk.nextToken());
                        int[] arr = new int[n+1];
                        int[] arr2 = new int[m+1];
                        stk = new StringTokenizer(br.readLine());
                        for(int i=1;i<=n;i++){
                                arr[i] = Integer.parseInt(stk.nextToken());
                        }
                        stk = new StringTokenizer(br.readLine());
                        for(int i=1;i<=m;i++){
                                arr2[i] = Integer.parseInt(stk.nextToken());
                        }
                        int ans = 0 ;
                        int[][] dp = new int[n+1][m+1];
                        int[] dp2 = new int[m+1];
                        for(int i=1;i<=m;i++){
                                dp2[i] = 1;
                                for(int j=1;j<i;j++){
                                        if(arr2[i]>arr2[j])
                                        dp2[i] = Math.max(dp2[i],dp2[j]+1);
                                }
                        }
                        for(int i=1;i<=n;i++){
                                int subMax = 1;
                                for(int j=1;j<=m;j++){
                                        if(arr[i]>arr2[j]) {
                                                      subMax = Math.max(subMax, dp2[j] + 1);
                                        }
                                        dp[i][j] = subMax;
                                }
                                for(int j=1;j<i;j++){
                                        if(arr[i]>arr[j]){
                                                for(int k=1;k<=m;k++){
                                                        dp[i][k] = Math.max(dp[i][k],dp[j][k]+1);
                                                }
                                        }
                                }
                                for(int j=1;j<=m;j++){
                                        for(int k=1;k<=i;k++){
                                                if(arr2[j]>arr[k]){
                                                        dp2[j] = Math.max(dp2[j],dp[k][j]+1);
                                                }
                                        }
                                }
                                for(int j=1;j<=m;j++){
                                        for(int k=1;k<j;k++){
                                                if(arr2[j]>arr2[k]){
                                                        dp2[j] = Math.max(dp2[j],dp2[k]+1);
                                                }
                                        }
                                }
                        }
                        ans = 0;
                        for(int i=1;i<=n;i++){
                                for(int j=1;j<=m;j++){
                                        ans = Math.max(ans,dp[i][j]);
                                        ans = Math.max(ans,dp2[j]);
                                }
                        }
                        System.out.println(ans);
                }
        }
}
